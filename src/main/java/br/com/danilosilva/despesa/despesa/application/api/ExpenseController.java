package br.com.danilosilva.despesa.despesa.application.api;

import br.com.danilosilva.despesa.despesa.application.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ExpenseController implements ExpenseAPI  {

    private final ExpenseService expenseService;

    @Override
    public ExpenseResponse createExpense(UUID idPeopleRegistered, ExpenseRequest expenseRequest) {
        log.info("[start] Create expense with id: " + idPeopleRegistered);
        ExpenseResponse expenseCreate = expenseService.createExpense(idPeopleRegistered, expenseRequest);
        log.info("[finished] Create expense with id: " + idPeopleRegistered);
        return expenseCreate;
    }
}