import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int student_id;
    private String student_name;
    private String student_branch;

    public Student() {}

    // Getters and Setters
    public int getStudent_id() { return student_id; }
    public void setStudent_id(int student_id) { this.student_id = student_id; }
    public String getStudent_name() { return student_name; }
    public void setStudent_name(String student_name) { this.student_name = student_name; }
    public String getStudent_branch() { return student_branch; }
    public void setStudent_branch(String student_branch) { this.student_branch = student_branch; }
}
