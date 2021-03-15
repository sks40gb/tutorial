import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private int id;
    private String name;
    private double salary;

    public double salaryIncrement(double increment) {
        this.salary += increment;
        return this.salary;
    }

}
