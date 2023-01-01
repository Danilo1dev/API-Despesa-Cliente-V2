package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.pessoa.application.api.*;
import java.util.List;
import java.util.UUID;

public interface PeopleService {
    PeopleResponse createPeople(PeopleRequest peopleRequest);
    List<PeopleListResponse> searchAllPeople();
    PeopleDetailedResponse getPersonViaID(UUID idPeople);
    void deletePersonViaID(UUID idPeople);
    void changePersonViaID(UUID idPeople, ChangePeopleRequest changePeopleRequest);
}
