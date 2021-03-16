import org.junit.Before;
import org.junit.Test;

import java.util.*;
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

    // count
    @Test
    public void whenStreamCount_thenGetElementCount() {
        long empCount = empList.stream()
            .filter(e -> e.getSalary() > 100000)
            .count();
        assertEquals(empCount, 2L);
    }

    // short-circuiting operations
    @Test
    public void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
        List<Integer> collect = infiniteStream
            .skip(3)  //<--
            .limit(5) //<--
            .collect(Collectors.toList());
        assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));
    }

    // Lazy Evaluation
    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream() {
        Integer[] empIds = { 1, 2, 3};

        Employee employee = Stream.of(empIds)
            .map(this::findById)
            .filter(e -> e != null)
            .filter(e -> e.getSalary() > 100000)
            .findFirst()
            .orElse(null);

        assertEquals(employee.getSalary(), new Double(200000));
    }

    // sorted
    @Test
    public void whenSortStream_thenGetSortedStream() {
        List<Employee> employees = empList.stream()
            .sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
            // OR Comparator.comparing(Employee::getName)
            .collect(Collectors.toList());
        assertEquals(employees.get(0).getName(), "Bill Gates");
        assertEquals(employees.get(1).getName(), "Jeff Bezos");
        assertEquals(employees.get(2).getName(), "Mark Zuckerberg");
    }

    // min
    @Test
    public void whenFindMin_thenGetMinElementFromStream() {
        Employee firstEmp = empList.stream()
            .min(Comparator.comparingInt(Employee::getId))
            .orElseThrow(NoSuchElementException::new);
        assertEquals(firstEmp.getId(), 1);
    }

    // max
    @Test
    public void whenFindMax_thenGetMaxElementFromStream() {
        Employee maxSalEmp = empList.stream()
            .max(Comparator.comparing(Employee::getSalary))
            .orElseThrow(NoSuchElementException::new);

        assertEquals(maxSalEmp.getSalary(), new Double(300000.0));
    }

    // distinct
    @Test
    public void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctList = intList.stream()
            .distinct()
            .collect(Collectors.toList());

        assertEquals(distinctList, Arrays.asList(2,5,3,4));
    }

    // allMatch, anyMatch, and noneMatch
    @Test
    public void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        assertFalse(allEven);
        assertTrue(oneEven);
        assertFalse(noneMultipleOfThree);
    }

}
