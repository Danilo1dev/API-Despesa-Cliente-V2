package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.pessoa.application.api.PeopleRequest;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleResponse;

public interface PeopleService {
    PeopleResponse createPeople(PeopleRequest peopleRequest);

}
