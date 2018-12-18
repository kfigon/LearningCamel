package pl.kamil;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new MyRoute());

        camelContext.start();
        Thread.sleep(2000);

        camelContext.stop();
    }
}
