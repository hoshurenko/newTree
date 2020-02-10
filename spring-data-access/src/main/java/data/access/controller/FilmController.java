package data.access.controller;

import data.access.model.Film;
import data.access.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@RestController
@RequestMapping(path = "/films")
public class FilmController {

    //    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @PersistenceUnit
    EntityManagerFactory factory;

    @GetMapping("/{filmId}")
    public Film getFilmById(@PathVariable("filmId") Integer filmId) {
        return entityManager.find(Film.class, filmId);
    }

    @PutMapping(path = "/{filmId}")
    @Transactional
    public void updateFilmTitleById(
            @PathVariable("filmId") Integer filmId,
            @RequestParam String title) {

//        Film film = entityManager.find(Film.class, filmId);
//        film.setTitle(title);
//        entityManager.persist(film);

        entityManager.createQuery(
                "update Film film set film.title = :title")
                .setParameter("title", title)
                .executeUpdate();
    }

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(path = "/all")
    private Iterable<Film> findAllFilms() {
        return filmRepository.findAll();
    }
}
