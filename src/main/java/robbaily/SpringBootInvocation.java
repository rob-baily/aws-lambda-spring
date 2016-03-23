package robbaily;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Rob on 3/22/2016.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan()
public class SpringBootInvocation {
    private ApplicationContext applicationContext;

    public SpringBootInvocation() {
    }

    public void run() {
        String[] args = new String[0];
        applicationContext = SpringApplication.run(SpringBootInvocation.class, args);
        /*
        applicationContext = new SpringApplicationBuilder()
                .main(getClass())
                .bannerMode(Banner.Mode.OFF)
                .web(false)
                .sources(getClass())
                .addCommandLineProperties(false)
                .build()
                .run();
       */
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Bean
    @Scope("prototype")
    public TestConfiguration testConfiguration() {
        return new TestConfiguration();
    }
}
