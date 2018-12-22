package pl.kamil;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransformRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new TransformRoute();
    }

    @Test
    public void checkIfCsvIsTransformed() {
        String input = "name,phone,123";
        String expectedOutut = "name*phone*123";

        String actual = (String)template.requestBody(TransformRoute.ROUTE_INPUT, input);

        assertEquals(expectedOutut, actual);
    }
}