import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreationTest {

    @Test
    public void stream_creation_from_of(){

        Stream.Builder<String> builder = Stream.builder();
        builder.accept("John");
        builder.accept("Alan");
        builder.accept("Sasa");

        Stream<String> employeeStream = builder.build();

        int size = employeeStream.collect(Collectors.counting()).intValue();

        Assertions.assertEquals(3, size);

    }
}
