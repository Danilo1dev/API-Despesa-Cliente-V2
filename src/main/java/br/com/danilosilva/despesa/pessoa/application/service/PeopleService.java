package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.pessoa.application.api.PeopleListResponse;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleRequest;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleResponse;
import java.util.List;

public interface PeopleService {
    PeopleResponse createPeople(PeopleRequest peopleRequest);
    List<PeopleListResponse> searchAllPeople();
}
