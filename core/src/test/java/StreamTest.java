import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StreamTest {

    private Employee[] arrayOfEmps = {
        new Employee(1, "Jeff Bezos", 100000.0),
        new Employee(2, "Bill Gates", 200000.0),
        new Employee(3, "Mark Zuckerberg", 300000.0)
    };


    // Java Stream Creation

    @Test
    public void stream_creation(){
        Stream.of(arrayOfEmps);
    }

}
