package hw17ToLesson30.dao;

import hw17ToLesson30.HibernateUtil;
import hw17ToLesson30.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO {

    public Student get(Integer id) {
        Student result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.get(Student.class, id);
        }
        return result;
    }

    public Student saveOrUpdate(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
        return student;
    }

    public List<Student> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Student a", Student.class).getResultList();
        }
    }

    public List<Student> findByNameContaining(String partOfFullName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String mask = "%" + partOfFullName + "%";
            return session.createQuery("SELECT a FROM Student a WHERE a.fio LIKE: searchKey", Student.class).setParameter("searchKey", mask).getResultList();
        }
    }
}
