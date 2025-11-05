---

## 🧩 **Q: Develop a simple Hibernate Web Application that displays total number of employees in an organization with its maximum, minimum, total, and average salary of employees.**

---

## **1️⃣ Employee.java (Entity Class)**

```java
package com.example;

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
```

---

## **2️⃣ hibernate.cfg.xml (Hibernate Configuration File)**

*(Place in `src/main/resources` or `WEB-INF/classes`)*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
    "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
    "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>

    <!-- Database Connection -->
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/testdb</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">root</property>

    <!-- Hibernate Settings -->
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
    <property name="hibernate.hbm2ddl.auto">update</property>
    <property name="show_sql">true</property>

    <!-- Mapping -->
    <mapping class="com.example.Employee"/>
  </session-factory>
</hibernate-configuration>
```

---

## **3️⃣ EmployeeStatsServlet.java (Controller Layer)**

```java
package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeStatsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // Aggregate queries using HQL
        Long totalEmployees = (Long) session.createQuery("select count(e) from Employee e").uniqueResult();
        Double maxSalary = (Double) session.createQuery("select max(e.salary) from Employee e").uniqueResult();
        Double minSalary = (Double) session.createQuery("select min(e.salary) from Employee e").uniqueResult();
        Double sumSalary = (Double) session.createQuery("select sum(e.salary) from Employee e").uniqueResult();
        Double avgSalary = (Double) session.createQuery("select avg(e.salary) from Employee e").uniqueResult();

        // Set attributes for JSP
        request.setAttribute("total", totalEmployees);
        request.setAttribute("max", maxSalary);
        request.setAttribute("min", minSalary);
        request.setAttribute("sum", sumSalary);
        request.setAttribute("avg", avgSalary);

        session.close();
        factory.close();

        RequestDispatcher rd = request.getRequestDispatcher("showStats.jsp");
        rd.forward(request, response);
    }
}
```

---

## **4️⃣ showStats.jsp (View Layer)**

```jsp
<html>
<head><title>Employee Statistics</title></head>
<body>
<h2>Employee Salary Statistics</h2>
<table border="1" cellpadding="5">
<tr><th>Detail</th><th>Value</th></tr>
<tr><td>Total Employees</td><td>${total}</td></tr>
<tr><td>Maximum Salary</td><td>${max}</td></tr>
<tr><td>Minimum Salary</td><td>${min}</td></tr>
<tr><td>Total Salary</td><td>${sum}</td></tr>
<tr><td>Average Salary</td><td>${avg}</td></tr>
</table>
</body>
</html>
```

---

## **5️⃣ web.xml (Deployment Descriptor)**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="3.1">
  <servlet>
    <servlet-name>EmployeeStatsServlet</servlet-name>
    <servlet-class>com.example.EmployeeStatsServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>EmployeeStatsServlet</servlet-name>
    <url-pattern>/empstats</url-pattern>
  </servlet-mapping>
</web-app>
```

---

## **🧠 Flow of Execution**

| Step | Description                                                           |
| ---- | --------------------------------------------------------------------- |
| 1    | Browser hits `http://localhost:8080/YourApp/empstats`                 |
| 2    | `EmployeeStatsServlet` connects to DB via Hibernate                   |
| 3    | HQL aggregate queries compute `count`, `max`, `min`, `sum`, and `avg` |
| 4    | Data is sent to JSP                                                   |
| 5    | JSP displays values in a clean table                                  |

---

## **🪄 Exam Tips**

| Point | Explanation                                                      |
| ----- | ---------------------------------------------------------------- |
| 1     | Always mention all 3 layers: Entity, Servlet, JSP                |
| 2     | Use HQL functions: `count()`, `max()`, `min()`, `sum()`, `avg()` |
| 3     | Remember `uniqueResult()` for single-value queries               |
| 4     | Include XML configuration — it’s a must in theory exams          |
| 5     | Keep DB connection simple (`root/root`, `testdb`)                |
| 6     | Mention flow: **Servlet → Hibernate → JSP**                      |

---
