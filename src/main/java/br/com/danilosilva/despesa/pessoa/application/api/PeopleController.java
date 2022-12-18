package br.com.danilosilva.despesa.pessoa.application.api;

import br.com.danilosilva.despesa.pessoa.application.service.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PeopleController implements PeopleAPI {
    private final PeopleService peopleService;

    @Override
    public PeopleResponse postPeople(PeopleRequest peopleRequest) {
        log.info("[start] PeopleController - postPeople");
        PeopleResponse peopleResponse = peopleService.createPeople(peopleRequest);
        log.info("[finished] PeopleController - postPeople");
        return peopleCreate;
    }
}
