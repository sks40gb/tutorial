import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class StreamCreationTest {


    private List<Employee> empList;
    private EmployeeRepository employeeRepository;

    @Before
    public void before() {
        Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
        };

      this.empList = Arrays.asList(arrayOfEmps);
      employeeRepository = mock(EmployeeRepository.class);

    }

    @Test
    public void stream_creation_from_of() {

        Stream.Builder<String> builder = Stream.builder();
        builder.accept("John");
        builder.accept("Alan");
        builder.accept("Sasa");

        Stream<String> employeeStream = builder.build();

        int size = employeeStream.collect(Collectors.counting()).intValue();

        assertEquals(3, size);

    }

    @Test
    public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {

        empList.stream().forEach(e -> e.salaryIncrement(10.0));

        assertThat(empList, contains(
            hasProperty("salary", equalTo(110000.0)),
            hasProperty("salary", equalTo(220000.0)),
            hasProperty("salary", equalTo(330000.0))
        ));
    }

    @Test
    public void whenIdMapToEmployee_thenGetMatchedEmployees(){
        Integer ids[] = {1,3};
        List<Employee> employeeList = Stream.of(ids).map(id -> employeeRepository.findById(id))
            .collect(Collectors.toList());
        assertEquals(3, employeeList.size());
    }

    private EmployeeRepository findById(Employee employee){
        when(employeeRepository.findById(employee.getId())).thenReturn(employee);
        return employeeRepository;
    }

}
