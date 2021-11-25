package ua.alevel.entity;

public class Employee extends BaseEntity{

    private String name;
    private String email;
    private int age;

    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
