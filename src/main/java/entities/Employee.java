package entities;

import javax.persistence.*;

@Entity
@Table(name = "employee_my")
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="age")
    private Integer age;

    @OneToOne
    @JoinColumn(name = "id_address")
    private EmployeeAddress employeeAddress;

    @ManyToOne
    @JoinColumn(name = "id_depts")
    private Departments departments;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    public Employee() {
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    /*public Employee(Integer id, String name, Integer age, EmployeeAddress employeeAddress, Departments departments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.employeeAddress = employeeAddress;
        this.departments = departments;
    }*/

    public EmployeeAddress getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddress employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    /*public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + this.id + ", " + this.name + ", " + this.age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Employee(Integer id, String name, Integer age, Departments departments, Country country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.departments = departments;
        this.country = country;
    }
}
