package br.com.danilosilva.despesa.people.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

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
    PeopleDetailedResponse getPersonViaID(@PathVariable String idPeople);

    @DeleteMapping(value = "/{idPeople}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePersonViaID(@PathVariable String idPeople);

    @PatchMapping(value = "/{idPeople}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void changePeople(@PathVariable String idPeople, @Valid @RequestBody ChangePeopleRequest changePeopleRequest);
}
