package br.com.danilosilva.despesa.pessoa.application.repository;

import br.com.danilosilva.despesa.pessoa.domain.People;
import java.util.List;

public interface PeopleRepository {
    People save(People people);

    List<People> searchAllPeople();
}
