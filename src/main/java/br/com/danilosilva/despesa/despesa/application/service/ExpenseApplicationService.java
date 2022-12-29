package br.com.danilosilva.despesa.despesa.application.service;

import br.com.danilosilva.despesa.despesa.application.api.ExpenseRequest;
import br.com.danilosilva.despesa.despesa.application.api.ExpenseResponse;
import br.com.danilosilva.despesa.despesa.application.repository.ExpenseRepository;
import br.com.danilosilva.despesa.despesa.domain.Expense;
import br.com.danilosilva.despesa.pessoa.application.service.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ExpenseApplicationService implements ExpenseService{

    private final PeopleService peopleService;
    private final ExpenseRepository expenseRepository;

    @Override
    public ExpenseResponse createExpense(UUID idPeopleRegistered, ExpenseRequest expenseRequest) {
        log.info("[start] Application service to creating expense: " + idPeopleRegistered);
        peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.saveExpense(new Expense(idPeopleRegistered, expenseRequest));
        log.info("[finished] Application service to creating expense: " + idPeopleRegistered);
        return new ExpenseResponse(expense.getIdExpense());
    }
}
