package pl.kamil;

import org.apache.camel.builder.RouteBuilder;

public class MyDirectRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:data/directInputDir")
                .log("Wiadomosc: ${body}")
                .to("file:data/directOutputDir?fileName=wynik.txt");
    }
}
