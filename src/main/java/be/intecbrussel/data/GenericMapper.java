package be.intecbrussel.data;

import be.intecbrussel.exceptions.AuthorNotFoundException;
import be.intecbrussel.model.EntityInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

// Uses T extends interface so the only classes T can be are Author Blog and Comments
public class GenericMapper<T extends EntityInterface> {
    public T addObject(T obj) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        obj = em.merge(obj);
        tx.commit();

        em.close();
        return obj;
    }

    public void removeObject(T obj, Object id) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        obj = (T) em.find(obj.getClass(), id);
        em.remove(obj);
        tx.commit();

        em.close();
    }

    public T getObject(T objTemplate, Object id) throws AuthorNotFoundException {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        T dbObj = (T) em.find(objTemplate.getClass(), id);
        if (dbObj == null)
            throw new AuthorNotFoundException();
        transaction.commit();

        em.close();
        return dbObj;
    }

}
