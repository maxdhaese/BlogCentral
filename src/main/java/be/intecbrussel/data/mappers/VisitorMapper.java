package be.intecbrussel.data.mappers;

import be.intecbrussel.data.EntityManagerFactoryProvider;
import be.intecbrussel.model.entities.TotalVisitTracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class VisitorMapper {
    public int amountOfVisitors() {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction et = em.getTransaction();
        Integer i;

        et.begin();
        try {
            i = (Integer) em.createQuery("SELECT totalVisits FROM TotalVisitTracker WHERE id=1").getSingleResult();
        } catch (NoResultException nre) {
            i = 0;
            em.persist(new TotalVisitTracker());
        }
        et.commit();
        em.close();
        return i;
    }

    public void updateVisitor(int count) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction et = em.getTransaction();

        et.begin();
        TotalVisitTracker tvt = em.find(TotalVisitTracker.class, 1);
        tvt.setTotalVisits(count);
        em.merge(tvt);
        et.commit();
        em.close();
    }
}
