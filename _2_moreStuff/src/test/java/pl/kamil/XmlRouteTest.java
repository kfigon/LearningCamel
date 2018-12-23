package pl.kamil;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class XmlRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XmlRoute();
    }

    @Test
    public void xmlTranslation() {
        String input ="<person>\n" +
                "    <name>Jan</name>\n" +
                "    <education>\n" +
                "        <school>First school</school>\n" +
                "        <school>second school</school>\n" +
                "        <school>some course</school>\n" +
                "    </education>\n" +
                "</person>";

        ParsedXmlPojo parsedXmlPojo = (ParsedXmlPojo) template.requestBody(XmlRoute.XML_ROUTE_IN, input);

        assertEquals("Jan", parsedXmlPojo.getName());
        List<String> names = parsedXmlPojo.getEducation().stream()
                .map(School::getSchool)
                .collect(Collectors.toList());
        assertEquals(names, Arrays.asList("First school", "second school", "some course"));
    }
}