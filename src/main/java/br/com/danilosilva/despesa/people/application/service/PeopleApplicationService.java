package br.com.danilosilva.despesa.people.application.service;

import br.com.danilosilva.despesa.expense.infra.ExpenseSpringDataMongoRepository;
import br.com.danilosilva.despesa.people.application.api.request.ChangePeopleRequest;
import br.com.danilosilva.despesa.people.application.api.request.PeopleRequest;
import br.com.danilosilva.despesa.people.application.api.response.PeopleDetailedResponse;
import br.com.danilosilva.despesa.people.application.api.response.PeopleExpenseResponse;
import br.com.danilosilva.despesa.people.application.api.response.PeopleListResponse;
import br.com.danilosilva.despesa.people.application.api.response.PeopleResponse;
import br.com.danilosilva.despesa.people.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.people.domain.entity.People;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PeopleApplicationService implements PeopleService {
    private final ExpenseSpringDataMongoRepository expenseSpringDataMongoRepository;
    private final PeopleRepository peopleRepository;

    @Override
    public PeopleResponse createPeople(PeopleRequest peopleRequest) {
        log.info("[start] PeopleApplicationService - createPeople");
        People people = peopleRepository.save(new People(peopleRequest));
        log.info("[finished] PeopleApplicationService - createPeople");
        return PeopleResponse.builder()
                .idPeople(people.getIdPeople())
                .build();
    }

    @Override
    public List<PeopleListResponse> searchAllPeople() {
        log.info("[start] PeopleApplicationService - searchAllPeople");
        List<People> peoples = peopleRepository.searchAllPeople();
        log.info("[finished] PeopleApplicationService - searchAllPeople");
        return PeopleListResponse.converte(peoples);
    }

    @Override
    public PeopleDetailedResponse getPersonViaID(String idPeople) {
        log.info("[start] PeopleApplicationService - getPersonViaID");
        log.info("[idPeople] {}", idPeople);
        People people = peopleRepository.searchPersonById(idPeople);
        log.info("[finished] PeopleApplicationService - getPersonViaID");
        return new PeopleDetailedResponse(people);
    }

    @Override
    public void deletePersonViaID(String idPeople) {
        log.info("[start] PeopleController - deletePersonViaID");
        People people = peopleRepository.searchPersonById(idPeople);
        peopleRepository.deletePeople(people);
        log.info("[finished] PeopleController - deletePersonViaID");
    }

    @Override
    public void changePersonViaID(String idPeople, ChangePeopleRequest changePeopleRequest) {
        log.info("[start] PeopleApplicationService - patchPersonViaID");
        People people = peopleRepository.searchPersonById(idPeople);
        people.change(changePeopleRequest);
        peopleRepository.save(people);
        log.info("[dateTimeLastChange] {}", LocalDateTime.now());
        log.info("[finished] PeopleApplicationService - patchPersonViaID");
    }

    @Override
    public List<PeopleExpenseResponse> getPeopleExpensesViaID(String idPeople) {
        log.info("[start] PeopleApplicationService - getPeopleExpensesViaID");
        log.info("[idPeople] {}", idPeople);
        People people = peopleRepository.searchPersonById(idPeople);
        log.info("[finished] PeopleApplicationService - getPeopleExpensesViaID");
        return PeopleExpenseResponse
                    .converte(expenseSpringDataMongoRepository.findByIdPeopleRegistered(idPeople));
    }
}
