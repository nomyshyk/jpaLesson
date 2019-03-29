package entities;

import javax.persistence.*;

@Entity
@Table(name = "employee_ali")
public class Employee {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="age")
    private Integer age;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dept")
    private Departments department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_county")
    private Country country;


    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public Employee(Integer id, String name, Integer age, Departments department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public Employee() {
    }

    public Employee(Integer id, String name, Integer age, Departments department, Country country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.country = country;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "РЎРѕС‚СЂСѓРґРЅРёРє: " + this.id + ", " + this.name + ", " + this.age;
    }

}
