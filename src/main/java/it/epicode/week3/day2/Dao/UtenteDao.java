package it.epicode.week3.day2.Dao;

import it.epicode.week3.day2.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UtenteDao {
    EntityManagerFactory emf;
    EntityManager em;
    public UtenteDao (){
        emf = Persistence.createEntityManagerFactory("gestionelibro");
        em = emf.createEntityManager();
    }

    public void save (Utente a){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(a);
        et.commit();
    }

    public Utente getById(Long id) {
        return em.find(Utente.class,id);
    }
    public void delete (Utente a){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Utente art = getById(a.getNumeroTessera());
        em.remove(art);
        et.commit();
    }
}
