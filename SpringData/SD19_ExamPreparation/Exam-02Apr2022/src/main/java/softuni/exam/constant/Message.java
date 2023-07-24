package softuni.exam.constant;

public enum Message {

    ;


    public static final String TOWNS_FILE = "src/main/resources/files/json/towns.json";
    public static final String AGENTS_FILE = "src/main/resources/files/json/agents.json";
    public static final String APARTMENTS_FILE = "src/main/resources/files/xml/apartments.xml";
    public static final String OFFERS_FILE = "src/main/resources/files/xml/offers.xml";

    public static final String INVALID_ENTITY = "Invalid %s";
    public static final String TOWN = "town";
    public static final String AGENT = "agent";
    public static final String APARTMENT = "apartment";
    public static final String OFFER = "offer";
    public static final String SUCCESSFUL_TOWN_IMPORT = "Successfully imported town %s - %d";
    public static final String SUCCESSFUL_AGENT_IMPORT = "Successfully imported agent - %s";
    public static final String SUCCESSFUL_APARTMENT_IMPORT = "Successfully imported apartment %s - %s";
    public static final String SUCCESSFUL_OFFER_IMPORT = "Successfully imported offer %s";
    public static final String PRINT_FORMAT =
            "Agent %s with offer №%d:\n" +
            "\t-Apartment area: %s\n" +
            "\t--Town: %s\n" +
            "\t---Price: %s$";
}
