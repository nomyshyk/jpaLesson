import entities.Country;
import entities.Departments;
import entities.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class Jpa3 {
    public static void main(String[] args) {
        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Country c1 = new Country(1, "KG");
        Country c2 = new Country(2, "KZ");
        Country c3 = new Country(3, "US");

        Departments d1 = new Departments(1, "IT");
        Departments d2 = new Departments(2, "Marketing");

        Employee e1 = new Employee(1, "Alexander", 52, d1, c1);
        Employee e2 = new Employee(2, "Alex", 42, d1, c1);
        Employee e3 = new Employee(3, "Joe", 10, d2, c3);
        Employee e4 = new Employee(4, "Andre", 15, d1, c3);
        session.beginTransaction();

        session.saveOrUpdate(c1);
        session.saveOrUpdate(c2);
        session.saveOrUpdate(c3);

        session.saveOrUpdate(d1);
        session.saveOrUpdate(d2);

        session.saveOrUpdate(e1);
        session.saveOrUpdate(e2);
        session.saveOrUpdate(e3);
        session.saveOrUpdate(e4);
        session.getTransaction().commit();

        /*for( Employee employee : a18(18, "A%")){
            System.out.println(employee.getName() +
                    " " + employee.getAge());
        };*/

        List<Employee> emps = session.createQuery("select e from Employee e " +
                "where e.department.id = :dep and e.country.id = :cnt")
                .setParameter("dep", "IT")
                .setParameter("cnt", "KG")
                .list();

        for( Employee employee : emps){
            System.out.println(employee.getName() +
                    " " + employee.getAge());
        }
        session.close();

    }

    public static List<Employee> a18(int age, String firstLetter){
        Session session =
                HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees =
                session.createQuery("select e from Employee e " +
                        "where age >= :p_age and name like :p_first")
                        .setParameter("p_age", age)
                        .setParameter("p_first", firstLetter)
                        .list();
        session.close();
        return employees;
    }



    public static void getLoad(){
        Session session =
                HibernateUtil.getSessionFactory().openSession();


        Employee e = new Employee(1, "One", 52, null, null);
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();

        System.out.println("before load");
        Employee employee =
                (Employee)session.load(Employee.class, 1);
        System.out.println("after load");
        System.out.println(employee.getAge() + " " + employee.getName());

        System.out.println("before get");
        Employee employeeG =
                (Employee)session.get(Employee.class, 1);
        System.out.println("after get");
        System.out.println(employeeG.getAge() + " " + employeeG.getName());

        session.close();
        System.out.println("Успешно создан " + e.toString());
    }
}
