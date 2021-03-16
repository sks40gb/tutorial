import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Double salary;

    public void salaryIncrement(Double increment) {
        this.salary = this.salary + this.salary /100 * increment;
    }
}
