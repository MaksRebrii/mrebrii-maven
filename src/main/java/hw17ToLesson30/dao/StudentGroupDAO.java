package hw17ToLesson30.dao;

import hw17ToLesson30.HibernateUtil;
import hw17ToLesson30.entity.StudentGroup;
import org.hibernate.Session;

import java.util.List;

public class StudentGroupDAO {

    public StudentGroup get(Integer id) {
        StudentGroup result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.get(StudentGroup.class, id);
        }
        return result;
    }

    public List<StudentGroup> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM StudentGroup a", StudentGroup.class).getResultList();
        }
    }

    public StudentGroup saveOrUpdate(StudentGroup studentGroup) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(studentGroup);
            session.getTransaction().commit();
        }
        return studentGroup;
    }

    /*public List<Student> getStudentsInGroup(StudentGroup group){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  group.getStudentsInGroup();
        }
    }*/
}
