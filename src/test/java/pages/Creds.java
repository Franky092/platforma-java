package pages;
import org.aeonbits.owner.Config;
@Config.Sources({"classpath:local.properties"})

public interface Creds extends Config {

    @Key("mainUsername")
    String MAIN_USERNAME();

    @Key("mainPassword")
    String MAIN_PASSWORD();

}
