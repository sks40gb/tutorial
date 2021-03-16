import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
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

    private Employee findById(Integer id) {
        Employee employee = empList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        when(employeeRepository.findById(id)).thenReturn(employee);
        return employeeRepository.findById(id);
    }

    // of
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

    // forEach
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
    public void whenIdMapToEmployee_thenGetMatchedEmployees() {
        Integer ids[] = {1, 3};
        List<Employee> employeeList = Stream.of(ids).map(id -> findById(id))
            .collect(Collectors.toList());
        assertEquals(2, employeeList.size());
    }

    // collect
    @Test
    public void whenCollectStreamToList_thenGetList() {
        List<Employee> employees = empList.stream().collect(Collectors.toList());

        assertEquals(empList, employees);
    }

    // filter
    @Test
    public void whenFilterEmployees_thenGetFilteredStream() {
        Integer[] empIds = {1, 2, 3};

        List<Employee> employees = Stream.of(empIds)
            .map(this::findById)
            .filter(Objects::nonNull)
            .filter(e -> e.getSalary() > 200000)
            .collect(Collectors.toList());

        assertEquals(Arrays.asList(empList.get(2)), employees);
    }

    // convert to an Array
    @Test
    public void whenStreamToArray_thenGetArray() {
        Employee[] employees = empList.stream().toArray(Employee[]::new);
        assertThat(empList.toArray(), equalTo(employees));
    }

    // flatMap
    @Test
    public void whenFlatMapEmployeeNames_thenGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(
            Arrays.asList("Jeff", "Bezos"),
            Arrays.asList("Bill", "Gates"),
            Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
            .flatMap(Collection::stream)  //OR
            //.flatMap(names -> names.stream())
            .collect(Collectors.toList());
        assertEquals(namesFlatStream.size(), namesNested.size() * 2);
    }

    // peek
    @Test
    public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {

        empList.stream()
            .peek(e->e.salaryIncrement(10d))
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertThat(empList, contains(
            hasProperty("salary", equalTo(110000.0)),
            hasProperty("salary", equalTo(220000.0)),
            hasProperty("salary", equalTo(330000.0))
        ));
    }

}
