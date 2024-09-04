package config;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:local.properties"})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remote")
    String getRemoteUrl();

}