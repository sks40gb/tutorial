import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.Assert.*;

public class StreamTest {

    private Employee[] arrayOfEmps = {
        new Employee(1, "Jeff Bezos", 100000.0),
        new Employee(2, "Bill Gates", 200000.0),
        new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    private List<Employee> empList = Arrays.asList(arrayOfEmps);

    // Java Stream Creation
    @Test
    public void stream_creation(){
        //1
        Stream<Employee> employeeStream = Stream.of(arrayOfEmps);

        //2
        Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);

    }

}
