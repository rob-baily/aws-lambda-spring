package robbaily;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Rob on 3/22/2016.
 */
public class TestConfiguration {
    @Value(value = "${configtest.value:default config value}")
    private String configValue;

    public String getConfigValue() {
        return configValue;
    }
}
