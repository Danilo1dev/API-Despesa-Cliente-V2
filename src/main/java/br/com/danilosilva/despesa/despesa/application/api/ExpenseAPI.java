package br.com.danilosilva.despesa.despesa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/expense")
public interface ExpenseAPI {

    @PostMapping(value = "/{idPeopleRegistered}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ExpenseResponse postExpense(@RequestBody ExpenseRequest expenseRequest);
}
