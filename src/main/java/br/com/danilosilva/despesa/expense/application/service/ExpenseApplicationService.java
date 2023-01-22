package br.com.danilosilva.despesa.expense.application.service;

import br.com.danilosilva.despesa.expense.application.api.*;
import br.com.danilosilva.despesa.expense.application.repository.ExpenseRepository;
import br.com.danilosilva.despesa.expense.domain.Expense;
import br.com.danilosilva.despesa.people.application.api.PeopleDetailedResponse;
import br.com.danilosilva.despesa.people.application.service.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ExpenseApplicationService implements ExpenseService{
    private final PeopleService peopleService;
    private final ExpenseRepository expenseRepository;

    @Override
    public ExpenseResponse createExpense(String idPeopleRegistered, ExpenseRequest expenseRequest) {
        log.info("[start] Application service to creating expense: " + idPeopleRegistered);
        peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.saveExpense(new Expense(idPeopleRegistered, expenseRequest));
        log.info("[finished] Application service to creating expense: " + idPeopleRegistered);
        return new ExpenseResponse(expense.getIdExpense());
    }

    @Override
    public List<ExpensePeopleListResponse> searchPersonExpenseWithId(String idPeopleRegistered) {
        log.info("[start] ApplicationService search person's expense list: " + idPeopleRegistered);
        peopleService.getPersonViaID(idPeopleRegistered);
        List<Expense> expensePeople = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered);
        log.info("[finished] ApplicationService search person's expense list: " + idPeopleRegistered);
        return ExpensePeopleListResponse.converte(expensePeople);
    }

    @Override
    public ExpenseDetailedResponse searchPersonExpenseWithId(String idPeopleRegistered, String idExpense) {
        log.info("[start] ApplicationService search person's expense list: " + idPeopleRegistered + " and idExpense: " + idExpense);
        PeopleDetailedResponse getPeopleViaID = peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered, idExpense);
        log.info("[finished] ApplicationService search person's expense list: " + idPeopleRegistered + " and idExpense: " + idExpense);
        return new ExpenseDetailedResponse(expense, getPeopleViaID);
    }

    @Override
    public void deleteExpense(String idPeopleRegistered, String idExpense) {
        log.info("[start] ApplicationService delete person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
        peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered, idExpense);
        expenseRepository.deleteExpense(expense);
        log.info("[finished] ApplicationService delete person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
    }

    @Override
    public void updateExpensePeopleWithId(String idPeopleRegistered, String idExpense, ExpenseChangeRequest expenseChangeRequest) {
        log.info("[start] ApplicationService - update person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
        peopleService.getPersonViaID(idPeopleRegistered);
        Expense expense = expenseRepository.searchExpenseOfPeopleId(idPeopleRegistered, idExpense);
        expense.updateExpense(expenseChangeRequest);
        expenseRepository.saveExpense(expense);
        log.info("[finished] ApplicationService - update person's expense: " + idPeopleRegistered + " and idExpense: " + idExpense);
        log.info("Expense updated: " + LocalDateTime.now());
    }
}
