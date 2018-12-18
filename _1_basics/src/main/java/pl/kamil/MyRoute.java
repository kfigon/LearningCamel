package pl.kamil;

import org.apache.camel.builder.RouteBuilder;


public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // file - component
        // data/input - directories
        // ?... parametry

        from("file:data/input?noop=true")
                .to("file:data/output");

        // to skopiuje plik z jednego do drugiego
//        noop  true nie usunie pliku data/input
    }
}
