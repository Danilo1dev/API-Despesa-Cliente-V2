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
    PeopleDetailedResponse getPersonViaID(@PathVariable UUID idPeople);

    @DeleteMapping(value = "/{idPeople}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePersonViaID(@PathVariable UUID idPeople);

    @PatchMapping(value = "/{idPeople}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void changePeople(@PathVariable UUID idPeople, @Valid @RequestBody ChangePeopleRequest changePeopleRequest);
}
