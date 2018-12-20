package pl.kamil;

import org.apache.camel.builder.RouteBuilder;


public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // file - component
        // data/input - directories
        // ?... parametry

        from("file:data/input?noop=true") // consumer, exchange objekt
                .to("log:?level=INFO")
                .to("file:data/output"); // jeden z producerow - wypluwa exhcnage do innego route

        // to skopiuje plik z jednego do drugiego
//        noop  true nie usunie pliku data/input

//        mozna wiele .to generowac, logi itd
    }
}
