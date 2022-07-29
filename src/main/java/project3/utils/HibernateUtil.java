package project3.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("tp-hibernate-basique");
    }

    public static EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
