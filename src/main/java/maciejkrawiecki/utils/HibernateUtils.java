package maciejkrawiecki.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

    private static HibernateUtils INSTANCE = new HibernateUtils();
    private SessionFactory sessionFactory;

    private HibernateUtils() {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.xml")
                .build();

        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static HibernateUtils getInstance() {
        return INSTANCE;
    }

    public static Session getSession() {
        SessionFactory sessionFactory = HibernateUtils.getInstance().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session;
    }
}
