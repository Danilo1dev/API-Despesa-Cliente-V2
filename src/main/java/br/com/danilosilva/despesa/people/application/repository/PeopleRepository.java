package br.com.danilosilva.despesa.people.application.repository;

import br.com.danilosilva.despesa.people.domain.People;
import java.util.List;
import java.util.UUID;

public interface PeopleRepository {
    People save(People people);
    List<People> searchAllPeople();
    People searchPersonById(UUID idPeople);
    void deletePeople(People people);
}
