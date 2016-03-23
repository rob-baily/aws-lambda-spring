package robbaily;

import com.amazonaws.services.lambda.runtime.Context;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by Rob on 3/22/2016.
 */
@Component
@Scope("prototype")
public class RequestComponent {
    static Log log = LogFactory.getLog(RequestComponent.class);

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Environment environment;

    @Value(value = "${configtest.value}")
    private String configValue;

    public String processRequest(String name, Context context) {
        log.info("In the hello function");
        log.info("Test value here = "+ configValue);
        log.info("env value = " + environment.getProperty("configtest.value"));
        TestConfiguration testConfiguration = applicationContext.getBean(TestConfiguration.class);
        log.info("Test configuration value = " + testConfiguration.getConfigValue());
        return String.format("Hello %s.", name);
    }
}
