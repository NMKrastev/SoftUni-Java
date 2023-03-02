package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface AccountControllerInterface {


    public boolean getRequireUniqueEmail() ;

    public int getMinRequiredPasswordLength();

    public int getMaxRequiredPasswordLength();
}
