package pl.kamil;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static java.lang.Thread.sleep;

public class MyRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new MyRoute();
    }

    @Test
    public void checkIfOutputDirExists() throws InterruptedException {
        sleep(3000);

        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);
    }
}
