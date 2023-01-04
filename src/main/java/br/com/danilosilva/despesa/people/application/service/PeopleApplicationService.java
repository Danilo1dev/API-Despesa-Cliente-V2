package br.com.danilosilva.despesa.people.application.service;

import br.com.danilosilva.despesa.people.application.api.*;
import br.com.danilosilva.despesa.people.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.people.domain.People;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PeopleApplicationService implements PeopleService {
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
    public PeopleDetailedResponse getPersonViaID(UUID idPeople) {
        log.info("[start] PeopleApplicationService - getPersonViaID");
        log.info("[idPeople] {}", idPeople);
        People people = peopleRepository.searchPersonById(idPeople);
        log.info("[finished] PeopleApplicationService - getPersonViaID");
        return new PeopleDetailedResponse(people);
    }

    @Override
    public void deletePersonViaID(UUID idPeople) {
        log.info("[start] PeopleController - deletePersonViaID");
        People people = peopleRepository.searchPersonById(idPeople);
        peopleRepository.deletePeople(people);
        log.info("[finished] PeopleController - deletePersonViaID");
    }

    @Override
    public void changePersonViaID(UUID idPeople, ChangePeopleRequest changePeopleRequest) {
        log.info("[start] PeopleApplicationService - patchPersonViaID");
        People people = peopleRepository.searchPersonById(idPeople);
        people.change(changePeopleRequest);
        peopleRepository.save(people);
        log.info("[dateTimeLastChange] {}", LocalDateTime.now());
        log.info("[finished] PeopleApplicationService - patchPersonViaID");
    }
}
