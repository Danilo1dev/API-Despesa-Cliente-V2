package br.com.danilosilva.despesa.people.application.service;

import br.com.danilosilva.despesa.people.application.api.request.ChangePeopleRequest;
import br.com.danilosilva.despesa.people.application.api.request.PeopleRequest;
import br.com.danilosilva.despesa.people.application.api.response.PeopleDetailedResponse;
import br.com.danilosilva.despesa.people.application.api.response.PeopleExpenseResponse;
import br.com.danilosilva.despesa.people.application.api.response.PeopleListResponse;
import br.com.danilosilva.despesa.people.application.api.response.PeopleResponse;

import java.util.List;

public interface PeopleService {
    PeopleResponse createPeople(PeopleRequest peopleRequest);
    List<PeopleListResponse> searchAllPeople();
    PeopleDetailedResponse getPersonViaID(String idPeople);
    void deletePersonViaID(String idPeople);
    void changePersonViaID(String idPeople, ChangePeopleRequest changePeopleRequest);
    List<PeopleExpenseResponse> getPeopleExpensesViaID(String idPeople);
}
