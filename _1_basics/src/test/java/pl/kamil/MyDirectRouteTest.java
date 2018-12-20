package pl.kamil;

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

        sleep(3000);

        File file = new File("data/directOutputDir");
        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);
    }
}

