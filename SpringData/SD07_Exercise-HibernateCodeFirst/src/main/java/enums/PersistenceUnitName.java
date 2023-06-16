package enums;

public enum PersistenceUnitName {

    GRINGOTTS("gringotts"),
    SALES("sales"),
    UNIVERSITY("university"),
    HOSPITAL("hospital");

    private final String persistenceUnitName;

    PersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }
}
