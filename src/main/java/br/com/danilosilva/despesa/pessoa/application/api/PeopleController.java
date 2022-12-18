package br.com.danilosilva.despesa.pessoa.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PeopleController implements PeopleAPI {
    @Override
    public PeopleResponse postPeople(PeopleRequest peopleRequest) {
        log.info("[start] PeopleController - postPeople");
        log.info("[finished] PeopleController - postPeople");
        return null;
    }
}
