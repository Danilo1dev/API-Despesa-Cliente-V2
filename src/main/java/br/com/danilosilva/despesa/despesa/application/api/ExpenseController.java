package br.com.danilosilva.despesa.despesa.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@Log4j2
public class ExpenseController implements ExpenseAPI  {

    @Override
    public ExpenseResponse postExpense(ExpenseRequest expenseRequest) {
        log.info("[start] ExpenseController - postExpense");
        log.info("[finished] ExpenseController - postExpense");
        return null;
    }
}
