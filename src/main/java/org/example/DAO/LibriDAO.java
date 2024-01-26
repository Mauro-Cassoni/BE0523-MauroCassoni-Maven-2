package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entities.BaseLibreria;
import org.example.entities.Libri;

import java.util.List;


public class LibriDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public LibriDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public void save(Libri e){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);
    }

    public Libri getById(int id){

        return em.find(Libri.class, id);

    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.remove( getById(id) );

        et.commit();

    }


    public void update(Libri e) {
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.merge(e);

        et.commit();
    }

    public List<Libri> getByAutore(String autore){

        return em.createNamedQuery("getByAutore",Libri.class)
                .setParameter("autore", autore)
                .getResultList();

    }


}
