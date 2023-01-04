package br.com.danilosilva.despesa.people.application.api;

import br.com.danilosilva.despesa.people.application.service.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PeopleController implements PeopleAPI {
    private final PeopleService peopleService;

    @Override
    public PeopleResponse postPeople(PeopleRequest peopleRequest) {
        log.info("[start] PeopleController - postPeople");
        PeopleResponse peopleCreate = peopleService.createPeople(peopleRequest);
        log.info("[finished] PeopleController - postPeople");
        return peopleCreate;
    }

    @Override
    public List<PeopleListResponse> getEveryBody() {
        log.info("[start] PeopleController - getEveryBody");
        List<PeopleListResponse> people= peopleService.searchAllPeople();
        log.info("[finished] PeopleController - getEveryBody");
        return people;
    }

    @Override
    public PeopleDetailedResponse getPersonViaID(UUID idPeople) {
        log.info("[start] PeopleController - getEveryBody");
        log.info("[idPeople] {}", idPeople);
        PeopleDetailedResponse detailedPerson = peopleService.getPersonViaID(idPeople);
        log.info("[finished] PeopleController - getEveryBody");
        return detailedPerson;
    }

    @Override
    public void deletePersonViaID(UUID idPeople) {
        log.info("[start] PeopleController - deletePersonViaID");
        log.info("[idPeople] {}", idPeople);
        peopleService.deletePersonViaID(idPeople);
        log.info("[finished] PeopleController - deletePersonViaID");
    }

    @Override
    public void changePeople(UUID idPeople, @Valid ChangePeopleRequest changePeopleRequest) {
        log.info("[start] PeopleController - changePeople");
        log.info("[idPeople] {}", idPeople);
        peopleService.changePersonViaID(idPeople, changePeopleRequest);
        log.info("[finished] PeopleController - changePeople");
    }
}
