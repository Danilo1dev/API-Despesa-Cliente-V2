package br.com.danilosilva.despesa.people.application.service;

import br.com.danilosilva.despesa.people.application.api.*;
import java.util.List;

public interface PeopleService {
    PeopleResponse createPeople(PeopleRequest peopleRequest);
    List<PeopleListResponse> searchAllPeople();
    PeopleDetailedResponse getPersonViaID(String idPeople);
    void deletePersonViaID(String idPeople);
    void changePersonViaID(String idPeople, ChangePeopleRequest changePeopleRequest);
    List<PeopleExpenseResponse> getPeopleExpensesViaID(String idPeople);
}
