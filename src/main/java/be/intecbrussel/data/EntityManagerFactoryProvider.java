package be.intecbrussel.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {
    // Create an entity manager factory with the persistence unit set to our database
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("datasourceLocal");
    // Returns an entity manager using the above factory
    public static EntityManager getEM() {
        return entityManagerFactory.createEntityManager();
    }

}
