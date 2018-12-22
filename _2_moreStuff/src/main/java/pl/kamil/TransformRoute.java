package pl.kamil;

import org.apache.camel.builder.RouteBuilder;

public class TransformRoute extends RouteBuilder {

    public static final String ROUTE_INPUT = "direct:pliki";
    public static final String ROUTE_OUTPUT = "mock:wyniki";

    @Override
    public void configure() throws Exception {

        from(ROUTE_INPUT)
                .transform(body().regexReplaceAll(",", "*"))
                .to(ROUTE_OUTPUT);
    }
}
