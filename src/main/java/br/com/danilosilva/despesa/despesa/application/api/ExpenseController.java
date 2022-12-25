package br.com.danilosilva.despesa.despesa.application.api;

import br.com.danilosilva.despesa.despesa.application.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ExpenseController implements ExpenseAPI  {

    private final ExpenseService expenseService;

    @Override
    public ExpenseResponse postExpense(UUID idPeopleRegistered, @Valid ExpenseRequest expenseRequest) {
        log.info("[start] ExpenseController - postExpense");
        log.info("[idPeople] {}" , idPeopleRegistered);
        log.info("[finished] ExpenseController - postExpense");
        return null;
    }
}
