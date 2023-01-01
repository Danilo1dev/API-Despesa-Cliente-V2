package br.com.danilosilva.despesa.despesa.application.service;

import br.com.danilosilva.despesa.despesa.application.api.*;
import br.com.danilosilva.despesa.despesa.application.repository.ExpenseRepository;
import br.com.danilosilva.despesa.despesa.domain.Expense;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleDetailedResponse;
import br.com.danilosilva.despesa.pessoa.application.service.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public List<ExpensePeopleListResponse> searchPersonExpenseWithId(UUID idPeopleRegistered) {
        log.info("[start] ApplicationService search person's expense list: " + idPeopleRegistered);
        peopleService.getPersonViaID(idPeopleRegistered);
        List<Expense> expensePeople = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered);
        log.info("[finished] ApplicationService search person's expense list: " + idPeopleRegistered);
        return ExpensePeopleListResponse.converte(expensePeople);
    }

    @Override
    public ExpenseDetailedResponse searchPersonExpenseWithId(UUID idPeopleRegistered, UUID idExpense) {
        log.info("[start] ApplicationService search person's expense list: " + idPeopleRegistered + " and idExpense: " + idExpense);
        PeopleDetailedResponse getPeopleViaID = peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered, idExpense);
        log.info("[finished] ApplicationService search person's expense list: " + idPeopleRegistered + " and idExpense: " + idExpense);
        return new ExpenseDetailedResponse(expense, getPeopleViaID);
    }

    @Override
    public void deleteExpense(UUID idPeopleRegistered, UUID idExpense) {
        log.info("[start] ApplicationService delete person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
        peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered, idExpense);
        expenseRepository.deleteExpense(expense);
        log.info("[finished] ApplicationService delete person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
    }

    @Override
    public void updateExpensePeopleWithId(UUID idPeopleRegistered, UUID idExpense, ExpenseChangeRequest expenseChangeRequest) {
        log.info("[start] ApplicationService - update person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
        peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered, idExpense);
        expense.updateExpense(expenseChangeRequest);
        expenseRepository.saveExpense(expense);
        log.info("[finished] ApplicationService - update person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
        log.info("Expense updated: " + LocalDateTime.now());
    }
}
