package pl.kamil;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;

public class XmlRoute extends RouteBuilder {

    public static final String XML_ROUTE_IN = "direct:/rozneFormaty/xmle/";
    public static final String XML_ROUTE_OUT = "mock:output";

    @Override
    public void configure() {
        from(XML_ROUTE_IN)
                .unmarshal(getJacksonConfig())
                .log("mam plik! ${body}, headery: ${headers}")
                .to(XML_ROUTE_OUT);
    }

    private JacksonXMLDataFormat getJacksonConfig() {
       JacksonXMLDataFormat jacksonXMLDataFormat = new JacksonXMLDataFormat();
       jacksonXMLDataFormat.setUnmarshalType(ParsedXmlPojo.class);

       return jacksonXMLDataFormat;
    }
}
