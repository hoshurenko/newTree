package data.access.controller;

import data.access.model.Actor;
import data.access.model.Language;
import data.access.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/actors")
public class ActorController {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping
    @Transactional
    private List getAllActors() {
        return entityManager.createNativeQuery("select * from actor ").getResultList();
    }

    @GetMapping(path = "/l")
    @Transactional
    private List getAllLanguages() {
        return (List) entityManager.createQuery(
                "select a.languageId, a.name from Language a ").getResultList();
    }

    @GetMapping(path = "/language-data")
    @Transactional
    private List<Language> getLanguage() {
        List resultList = entityManager.createNativeQuery(
                "select language_id, name from language;")
                .getResultList();
        List<Language> languages = new ArrayList<>();
        for (Object o : resultList) {
            languages.add(convert((Object[]) o));
        }
        return languages;
    }

    private Language convert(Object[] array) {
        Language language = new Language();
        language.setLanguageId((Byte) array[0]);
        language.setName((String) array[1]);
        return language;
    }

    @GetMapping("/all")
    private Iterable<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    @GetMapping(path = "/{actorId}")
    private Optional<Actor> findActorById(@PathVariable("actorId") Integer actorId) {
        return actorRepository.findById(actorId);
    }

}
