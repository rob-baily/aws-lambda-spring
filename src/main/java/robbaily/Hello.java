package robbaily;

import com.amazonaws.services.lambda.runtime.*;

/**
 * Created by Rob on 3/22/2016.
 */
public class Hello implements RequestHandler <String, String> {
    public String handleRequest(String name, Context context) {
        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
        springBootInvocation.run();
        return springBootInvocation.getApplicationContext().getBean(RequestComponent.class).processRequest(name,context);
    }

    public static void main(String[] args) {
        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
        springBootInvocation.run();
        springBootInvocation.getApplicationContext().getBean(RequestComponent.class).processRequest("Robert",null);
    }
}
