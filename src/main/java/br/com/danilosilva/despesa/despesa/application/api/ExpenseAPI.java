package br.com.danilosilva.despesa.despesa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/expense")
public interface ExpenseAPI {

    @PostMapping(value = "{idPeopleRegistered}")
    @ResponseStatus(HttpStatus.CREATED)
    ExpenseResponse createExpense(@PathVariable UUID idPeopleRegistered,
                                  @Valid @RequestBody ExpenseRequest expenseRequest);

    @GetMapping(value = "{idPeopleRegistered}")
    @ResponseStatus(HttpStatus.OK)
    List<ExpensePeopleListResponse> getExpensePeopleId(@PathVariable UUID idPeopleRegistered);

    @GetMapping(value = "{idPeopleRegistered}/{idExpense}")
    @ResponseStatus(HttpStatus.OK)
    ExpenseDetailedResponse getExpensePeopleId(@PathVariable UUID idPeopleRegistered,
                                               @PathVariable UUID idExpense);

    @DeleteMapping(value = "{idPeopleRegistered}/{idExpense}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteExpensePeopleId(@PathVariable UUID idPeopleRegistered,
                               @PathVariable UUID idExpense);
}
