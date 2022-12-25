package br.com.danilosilva.despesa.pessoa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/people")
public interface PeopleAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PeopleResponse postPeople(@Valid @RequestBody PeopleRequest peopleRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PeopleListResponse> getEveryBody();

    @GetMapping(value = "/{idPeople}")
    @ResponseStatus(HttpStatus.OK)
    DetailedPersonResponse getPersonViaID(@PathVariable UUID idPeople);

    @DeleteMapping(value = "/{idPeople}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePersonViaID(@PathVariable UUID idPeople);


}
