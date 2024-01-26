package it.epicode.week3.day2.Dao;

import it.epicode.week3.day2.entities.Articolo;
import jakarta.persistence.*;

import java.util.List;

public class ArticoloDao {
    EntityManagerFactory emf;
    EntityManager em;

    public ArticoloDao() {
        emf = Persistence.createEntityManagerFactory("gestionelibro");
        em = emf.createEntityManager();
    }

    public List<Articolo> cercaPerAnno(int anno) {
        try {
            TypedQuery<Articolo> query = em.createQuery("select a from Articolo a where a.annoPubblicazione = : anno", Articolo.class);
            query.setParameter("anno", anno);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Articolo> cercaPerAutore(String autore) {

        try {
            TypedQuery<Articolo> query = em.createQuery("select a from Articolo a where a.autore = :autore", Articolo.class);
            query.setParameter("autore", autore);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Articolo> cercaPerTitolo(String a) {
        try {
            TypedQuery query = em.createQuery("select a from Articolo a where a.titolo LIKE :a", Articolo.class);
            query.setParameter("a", "%" + a + "%");
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void save(Articolo a) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(a);
        et.commit();
    }

    public Articolo getById(Long id) {
        return em.find(Articolo.class, id);
    }

    public void delete(Articolo a) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Articolo art = getById(a.getIsbn());
        em.remove(art);
        et.commit();
    }
}
