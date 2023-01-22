package br.com.danilosilva.despesa.expense.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/expense")
public interface ExpenseAPI {

    @PostMapping(value = "{idPeopleRegistered}")
    @ResponseStatus(HttpStatus.CREATED)
    ExpenseResponse createExpense(@PathVariable String idPeopleRegistered,
                                  @Valid @RequestBody ExpenseRequest expenseRequest);

    @GetMapping(value = "{idPeopleRegistered}")
    @ResponseStatus(HttpStatus.OK)
    List<ExpensePeopleListResponse> getExpensePeopleId(@PathVariable String idPeopleRegistered);

    @GetMapping(value = "{idPeopleRegistered}/{idExpense}")
    @ResponseStatus(HttpStatus.OK)
    ExpenseDetailedResponse getExpensePeopleId(@PathVariable String idPeopleRegistered,
                                               @PathVariable String idExpense);

    @DeleteMapping(value = "{idPeopleRegistered}/{idExpense}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteExpensePeopleId(@PathVariable String idPeopleRegistered,
                               @PathVariable String idExpense);

    @PatchMapping(value = "{idPeopleRegistered}/{idExpense}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateExpensePeopleId(@PathVariable String idPeopleRegistered,
                               @PathVariable String idExpense,
                               @Valid @RequestBody ExpenseChangeRequest expenseChangeRequest);
}
