package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entities.Libri;
import org.example.entities.Riviste;


public class RivisteDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public RivisteDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public void save(Riviste e){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);
    }

    public Riviste getById(int id){

        return em.find(Riviste.class, id);

    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.remove( getById(id) );

        et.commit();

    }


    public void update(Riviste e) {
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.merge(e);

        et.commit();
    }


}
