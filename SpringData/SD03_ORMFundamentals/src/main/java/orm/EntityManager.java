package orm;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DBContext<E> {

    private static final String VALUES_SPLITTER = ",\\s+";
    private static final String VALUES_FORMAT = "'%s'";
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws SQLException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {

        String tableName = this.getTableName(entity.getClass());
        String columnList = this.getDBColumnsWithoutID(entity);
        String valuesList = this.getValuesWithoutID(entity);
        Long primaryKey = this.getId(entity);

        if (primaryKey == null || primaryKey <= 0) {
            return this.doInsert(tableName, columnList, valuesList);
        }

        return this.doUpdate(entity, tableName, columnList, valuesList, primaryKey);
    }

    @Override
    public boolean delete(E entity) throws IllegalAccessException, SQLException {

        return this.delete(entity, null);
    }

    @Override
    public boolean delete(E entity, String where) throws IllegalAccessException, SQLException {

        String tableName = this.getTableName(entity.getClass());
        Long primaryKey = this.getId(entity);

        String query = String.format("DELETE FROM %s WHERE %s", tableName,
                String.format(where == null
                        ? String.format("id = %d", primaryKey)
                        : where));

        return this.connection.prepareStatement(query).execute();
    }

    @Override
    public Iterable<E> find(Class<E> entityType) throws SQLException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        return find(entityType, null);
    }

    @Override
    public Iterable<E> find(Class<E> entityType, String where) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        String tableName = this.getTableName(entityType);

        String query = String.format("SELECT * FROM %s %s", tableName,
                String.format(where == null ? "" : "WHERE %s", where));

        ResultSet resultSet = this.connection.prepareStatement(query).executeQuery();

        List<E> result = new ArrayList<>();

        E entity = this.createEntity(entityType, resultSet);

        while (entity != null) {

            result.add(entity);

            entity = this.createEntity(entityType, resultSet);

        }

        return result;
    }

    @Override
    public E findFirst(Class<E> entityType) throws SQLException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        return findFirst(entityType, null);
    }

    @Override
    public E findFirst(Class<E> entityType, String where) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        String tableName = this.getTableName(entityType);

        String query = String.format("SELECT * FROM %s %s LIMIT 1", tableName,
                String.format(where == null ? "" : "WHERE %s", where));

        ResultSet resultSet = this.connection.prepareStatement(query).executeQuery();

        return this.createEntity(entityType, resultSet);
    }

    private String getTableName(Class<?> clazz) {

        Entity annotation = clazz.getAnnotation(Entity.class);

        if (annotation == null) {
            throw new ORMException("Provided class does not have entity annotation!");
        }

        return annotation.name();
    }

    private String getDBColumnsWithoutID(E entity) {

        return Arrays.stream(entity
                        .getClass()
                        .getDeclaredFields())
                .filter(e -> e.getAnnotation(Column.class) != null)
                .map(e -> e.getAnnotation(Column.class).name())
                .collect(Collectors.joining(", "));
    }

    private String getValuesWithoutID(E entity) throws IllegalAccessException {

        Field[] declaredFields = entity.getClass().getDeclaredFields();

        List<String> result = new ArrayList<>();

        for (Field declaredField : declaredFields) {

            if (declaredField.getAnnotation(Column.class) == null) {
                continue;
            }

            declaredField.setAccessible(true);

            Object value = declaredField.get(entity);

            result.add(String.format(VALUES_FORMAT, value.toString()));
        }

        return String.join(", ", result);
    }

    private boolean doInsert(String tableName, String columnList, String valuesList) throws SQLException {

        String query = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columnList, valuesList);

        return this.connection.prepareStatement(query).execute();
    }

    private boolean doUpdate(E entity, String tableName, String columnList, String valuesList, Long primaryKey)
            throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String where = String.format("id = %d", primaryKey);

        Object entityObject = this.findFirst((Class<E>) entity.getClass(), where);

        String valuesFromTable = this.getValuesWithoutID((E) entityObject);

        String query = "";

        if (!valuesList.equals(valuesFromTable)) {

            StringBuilder setBuilderForValues = new StringBuilder();
            setBuilderForValues.append("SET ");

            String[] columnsName = columnList.split(VALUES_SPLITTER);
            String[] oldTableValues = valuesFromTable.split(VALUES_SPLITTER);
            String[] newTableValues = valuesList.split(VALUES_SPLITTER);

            for (int i = 0; i < oldTableValues.length; i++) {

                if (!newTableValues[i].equals(oldTableValues[i])) {

                    setBuilderForValues.append(columnsName[i])
                            .append(" = ")
                            .append(newTableValues[i])
                            .append(", ");
                }
            }

            int deleteIndex = setBuilderForValues.lastIndexOf( ", ");
            setBuilderForValues.delete(deleteIndex, deleteIndex + 2);

            query = String.format("UPDATE %s %s WHERE %s;", tableName, setBuilderForValues, where);
        }

        if (query.isEmpty()) {
            return false;
        }

        return this.connection.prepareStatement(query).execute();
    }

    private Long getId(E entity) throws IllegalAccessException {

        Field primaryKey = Arrays.stream(entity
                        .getClass()
                        .getDeclaredFields())
                .filter(e -> e.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(()
                        -> new ORMException(
                        String.format("%s does not have primary key!", entity.getClass().getSimpleName())));

        primaryKey.setAccessible(true);

        return (long) primaryKey.get(entity);
    }

    private E createEntity(Class<E> entityType, ResultSet resultSet) throws SQLException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        if (!resultSet.next()) {
            return null;
        }

        E entity = entityType.getDeclaredConstructor().newInstance();

        Field[] declaredFields = entityType.getDeclaredFields();

        for (Field declaredField : declaredFields) {

            if (!declaredField.isAnnotationPresent(Column.class)
                    && !declaredField.isAnnotationPresent(Id.class)) {
                continue;
            }

            Column columnAnnotation = declaredField.getAnnotation(Column.class);

            String columnName = columnAnnotation != null
                    ? columnAnnotation.name()
                    : declaredField.getName();

            String value = resultSet.getString(columnName);

            entity = this.fillData(entity, declaredField, value);
        }

        return entity;
    }

    private E fillData(E entity, Field field, String value) throws IllegalAccessException {

        field.setAccessible(true);

        if (field.getType() == long.class || field.getType() == Long.class) {

            field.setLong(entity, Long.parseLong(value));

        } else if (field.getType() == int.class || field.getType() == Integer.class) {

            field.setInt(entity, Integer.parseInt(value));

        } else if (field.getType() == LocalDate.class) {

            field.set(entity, LocalDate.parse(value));

        } else if (field.getType() == String.class) {

            field.set(entity, value);

        } else {

            throw new ORMException(String.format("Unsupported type %s", field.getType()));
        }

        return entity;
    }
}
