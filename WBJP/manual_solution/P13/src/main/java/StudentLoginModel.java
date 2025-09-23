
public class StudentLoginModel {
    private String username;
    private String password;
    private String course;
    private boolean loginStatus;

    public StudentLoginModel() {
        this.loginStatus = false;
    }

    public StudentLoginModel(String username, String password) {
        this.username = username;
        this.password = password;
        this.loginStatus = false;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}