package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.pessoa.application.api.PeopleListResponse;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleRequest;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleResponse;
import br.com.danilosilva.despesa.pessoa.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.pessoa.domain.People;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

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
        log.info("[finished] PeopleApplicationService - searchAllPeople");
        return null;
    }
}
