import entities.Departments;
import entities.Employee;
import entities.EmployeeAddress;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        EmployeeAddress ea =
                new EmployeeAddress(1, "Кое где 15");
        Departments d1 =
                new Departments(1, "IT");
        Employee e1 = new Employee(1, "one", 56, ea, d1);


        createEmployeeAddress(ea);
        create(e1);



        /*deleteAll();

        Employee e1 = new Employee(1, "one", 56);
        Employee e2 = new Employee(2, "two", 46);
        Employee e3 = new Employee(3, "three", 36);
        create(e1);
        create(e2);
        create(e3);

        List<Employee> employees = read();
        employees.stream().filter( x-> x.getName().contains("t"))
                .forEach(System.out::println);

        Employee e4 = new Employee(3, "three new", 26);
        update(e4);*/
    }

    public static Integer create(Employee e) {
        Session session =
                HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно создан " + e.toString());
        return e.getId();
    }

    public static Integer createEmployeeAddress(EmployeeAddress e) {
        Session session =
                HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно создан " + e.toString());
        return e.getId();
    }

    public static List<Employee> read(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        List<Employee>employees=session.createQuery("FROM Employee").list();
        session.close();
        System.out.println("Найдено "+ employees.size() + " сотрудников");
        return employees;
    }

    public static void update (Employee e){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee em=(Employee)session.load(Employee.class,e.getId());
        em.setName(e.getName());
        em.setAge(e.getAge());
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно изменен "+ e.toString());

    }

    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Employee ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно удалены все записи в Employee.");
    }

    public static void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee e = findByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно удалено " + e.toString());
    }
    public static Employee findByID(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee e = (Employee) session.load(Employee.class, id);
        session.close();
        return e;
    }



}
