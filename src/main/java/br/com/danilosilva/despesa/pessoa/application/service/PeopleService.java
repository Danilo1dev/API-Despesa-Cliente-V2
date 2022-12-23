package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.pessoa.application.api.DetailedPersonResponse;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleListResponse;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleRequest;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleResponse;
import java.util.List;
import java.util.UUID;

public interface PeopleService {
    PeopleResponse createPeople(PeopleRequest peopleRequest);
    List<PeopleListResponse> searchAllPeople();
    DetailedPersonResponse getPersonViaID(UUID idPeople);
}
