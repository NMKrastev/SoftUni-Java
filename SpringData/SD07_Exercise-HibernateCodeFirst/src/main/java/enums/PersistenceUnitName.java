package enums;

public enum PersistenceUnitName {

    GRINGOTTS("gringotts"),
    SALES("sales"),
    UNIVERSITY("university"),
    HOSPITAL("hospital"),
    BILLING_SYSTEM("billing_system");

    private final String persistenceUnitName;

    PersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }
}
