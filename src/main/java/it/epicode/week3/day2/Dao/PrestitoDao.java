package it.epicode.week3.day2.Dao;

import it.epicode.week3.day2.entities.Articolo;
import it.epicode.week3.day2.entities.PrestitoArticolo;
import jakarta.persistence.*;

import java.util.List;

public class PrestitoDao {
    EntityManagerFactory emf;
    EntityManager em;
    public PrestitoDao (){
        emf = Persistence.createEntityManagerFactory("gestionelibro");
        em = emf.createEntityManager();
    }

    public void save (PrestitoArticolo a){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(a);
        et.commit();
    }

    public List<Articolo> cercaPerNrTesseraEtPrestito (Long numTes){
        try {
            TypedQuery<Articolo> query = em.createQuery("SELECT pa.articolo FROM PrestitoArticolo pa JOIN pa.utente u " +
                            "WHERE pa.getDataRestituzioneEffettiva IS NULL AND u.numeroTessera = :numTes",
                    Articolo.class);
            query.setParameter("numTes", numTes);
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    public List<PrestitoArticolo> cercaprestitiScadutiEnonRestituiti (){
        try {
            TypedQuery<PrestitoArticolo> query = em.createQuery("SELECT p FROM PrestitoArticolo p " +
                    "WHERE p.getDataRestituzioneEffettiva IS NULL " +
                    "OR FUNCTION('NOW') > p.dataRestituzionePrevista", PrestitoArticolo.class);
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    public PrestitoArticolo getById(Long id) {
        return em.find(PrestitoArticolo.class,id);
    }
    public void delete (PrestitoArticolo a){
        EntityTransaction et = em.getTransaction();
        et.begin();
        PrestitoArticolo art = getById(a.getId());
        em.remove(art);
        et.commit();
    }
}
