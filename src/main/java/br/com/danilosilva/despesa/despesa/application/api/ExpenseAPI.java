package br.com.danilosilva.despesa.despesa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/expense")
public interface ExpenseAPI {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    ExpenseResponse postExpense(@PathVariable UUID idPeopleRegistered, @Valid @RequestBody ExpenseRequest expenseRequest);
}
