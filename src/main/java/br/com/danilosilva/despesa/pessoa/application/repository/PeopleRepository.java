package br.com.danilosilva.despesa.pessoa.application.repository;

import br.com.danilosilva.despesa.pessoa.domain.People;

public interface PeopleRepository {
    People save(People people);
}
