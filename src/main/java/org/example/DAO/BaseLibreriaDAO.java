package org.example.DAO;

import jakarta.persistence.*;
import org.example.entities.BaseLibreria;

import java.time.LocalDate;
import java.util.List;
public class BaseLibreriaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public BaseLibreriaDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public void save(BaseLibreria e){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);
    }

    public BaseLibreria getById(int id){

        return em.find(BaseLibreria.class, id);

    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.remove( getById(id) );

        et.commit();

    }


    public void update(BaseLibreria e) {
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.merge(e);

        et.commit();
    }

    public List<BaseLibreria> getByAnno(int data){

        return em.createNamedQuery("getByAnno",BaseLibreria.class)
        .setParameter("anno_pubblicazione", data)
        .getResultList();

    }

    public List<BaseLibreria> getTitoloList(String partialTitolo) {

        return em.createNamedQuery("getTitoloList", BaseLibreria.class)
                .setParameter("titolo", "%" + partialTitolo + "%")
                .getResultList();

    }


}
