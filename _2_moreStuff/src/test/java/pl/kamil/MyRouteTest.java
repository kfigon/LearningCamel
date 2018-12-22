package pl.kamil;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MyRoute();
    }

    @Test
    public void mockRouteTest() throws InterruptedException {
        String wejscie = "moj tekst!";
        String wyjscie = "aaaa moj tekst! aaaa";

        MockEndpoint mockEndpoint = getMockEndpoint(MyRoute.MOCK_OUTPUT_ROUTE);
        mockEndpoint.expectedBodiesReceived(wyjscie);

        template.sendBody(MyRoute.MOCK_INPUT_ROUTE, wejscie);
        assertMockEndpointsSatisfied();
    }
}