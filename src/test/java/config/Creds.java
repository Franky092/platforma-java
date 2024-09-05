package config;
import org.aeonbits.owner.Config;
@Config.Sources({"classpath:${env}.properties"})

public interface Creds extends Config {

    @Key("MAIN_USERNAME")
    String MAIN_USERNAME();

    @Key("MAIN_PASSWORD")
    String MAIN_PASSWORD();

}
