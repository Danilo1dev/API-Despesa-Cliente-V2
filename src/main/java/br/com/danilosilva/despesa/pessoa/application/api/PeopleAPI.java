package br.com.danilosilva.despesa.pessoa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/people")
public interface PeopleAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PeopleResponse postPeople(@RequestBody PeopleRequest peopleRequest);
}
