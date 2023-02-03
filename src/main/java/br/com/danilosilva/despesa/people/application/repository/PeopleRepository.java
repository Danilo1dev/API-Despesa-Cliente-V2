package br.com.danilosilva.despesa.people.application.repository;

import br.com.danilosilva.despesa.people.domain.entity.People;
import java.util.List;

public interface PeopleRepository {
    People save(People people);
    List<People> searchAllPeople();
    People searchPersonById(String idPeople);
    void deletePeople(People people);
}
