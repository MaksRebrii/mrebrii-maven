package hw17ToLesson30;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static volatile SessionFactory sessionFactory;

    private HibernateUtil(){}

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            synchronized (HibernateUtil.class){
                if (sessionFactory == null){
                    sessionFactory = buildSessionFactory();
                }
            }
        return sessionFactory;
    }

}
