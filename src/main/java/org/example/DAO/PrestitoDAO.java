package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entities.Prestito;
import org.example.entities.Utente;

import java.time.LocalDate;
import java.util.List;


public class PrestitoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PrestitoDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public void save(Prestito e){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);
    }

    public Prestito getById(int id){

        return em.find(Prestito.class, id);

    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.remove( getById(id) );

        et.commit();

    }


    public void update(Prestito e) {
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.merge(e);

        et.commit();
    }

    public List<Prestito> getElementiPrestito(int numero_tessera){

        return em.createNamedQuery("getElementiPrestito", Prestito.class)
                .setParameter("numero",numero_tessera)
                .getResultList();

    }

    public List<Prestito> getScaduti(){

        return em.createNamedQuery("getScaduti", Prestito.class)
                .getResultList();

    }


}
