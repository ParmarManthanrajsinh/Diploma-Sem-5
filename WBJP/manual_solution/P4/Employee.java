import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private int emp_id;
    private String emp_name;
    private double salary;

    public Employee() {}

    // Getters and Setters
    public int getEmp_id() { return emp_id; }
    public void setEmp_id(int emp_id) { this.emp_id = emp_id; }
    public String getEmp_name() { return emp_name; }
    public void setEmp_name(String emp_name) { this.emp_name = emp_name; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
