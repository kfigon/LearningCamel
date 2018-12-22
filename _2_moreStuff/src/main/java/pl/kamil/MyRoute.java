package pl.kamil;

import org.apache.camel.builder.RouteBuilder;

public class MyRoute extends RouteBuilder {


    public static final String MOCK_OUTPUT_ROUTE = "mock:output";
    public static final String MOCK_INPUT_ROUTE = "direct:pliki";

    @Override
    public void configure() throws Exception {
        from(MOCK_INPUT_ROUTE)
                .log("Odczytalem ${body}, headery: ${headers}")
                .to(MOCK_OUTPUT_ROUTE); // mock component
    }
}
