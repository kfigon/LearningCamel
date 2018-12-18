package pl.kamil;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("yo! Starting route...");

        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new MyRoute());

        System.out.println("start route...");
        camelContext.start();
        Thread.sleep(2000);

        System.out.println("stop route");
        camelContext.stop();
    }
}
