import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BasicTest {

    @Test
    public void getDetails() throws IOException, ParseException {
       Basic.GetDetails();
        System.out.println("test >>>>>>>>>>.");
    }
}