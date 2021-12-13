package org.example;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

class ArtistDaoImpl implements ArtistDao {

    EntityManagerFactory emf;
    EntityManager em;

    ArtistDaoImpl(){
        emf = Persistence.createEntityManagerFactory("labb4");
        em = emf.createEntityManager();
    }

    @Override
    public void createArtist(Artist artist) {
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
    }

    @Override
    public Artist getById(int id) {
        return em.find(Artist.class, id);
    }

    @Override
    public void deleteArtist(Artist artist) {
        em.getTransaction().begin();
        em.remove(artist);
        em.getTransaction().commit();
    }

    @Override
    public void update(Artist artist) {
        em.getTransaction().begin();
        em.merge(artist);
        em.getTransaction().commit();
    }

    @Override
    public List<Artist> selectAll() {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a", Artist.class);
        return query.getResultList();
    }

    @Override
    public List<Artist> selectByName(String name) {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a WHERE CONCAT(a.firstName, ' ', a.lastName) LIKE :name", Artist.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public List<Artist> selectByAgeInterval(int from, int to) {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a WHERE a.age BETWEEN :from AND :to", Artist.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }

    @Override
    public List<Artist> selectByGenre(String genre) {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a WHERE a.genre = :genre", Artist.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    @Override
    public List<Artist> selectByGender(Gender gender) {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a WHERE a.gender = :gender", Artist.class);
        query.setParameter("gender", gender);
        return query.getResultList();
    }

}
