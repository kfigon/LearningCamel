package pl.kamil;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static java.lang.Thread.sleep;

public class MyDirectRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new MyDirectRoute();
    }

    @Test
    public void checkIfOutputDirExists() throws InterruptedException {

        template.sendBody("direct:data/directInputDir",
                "1234, imie, nazwisko");

        sleep(5000);

        File file = new File("data/directOutputDir");
        assertTrue(file.isDirectory());

        Exchange wynik = consumer.receive("file:data/directOutputDir");

        // tak w route zrobione, taka nazwa pliku
        assertEquals("wynik.txt", wynik.getIn().getHeader("CamelFileName"));
    }
}

