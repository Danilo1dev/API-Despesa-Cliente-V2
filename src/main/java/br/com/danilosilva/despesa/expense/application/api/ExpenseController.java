package br.com.danilosilva.despesa.expense.application.api;

import br.com.danilosilva.despesa.expense.application.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ExpenseController implements ExpenseAPI  {
    private final ExpenseService expenseService;

    @Override
    public ExpenseResponse createExpense(String idPeopleRegistered, ExpenseRequest expenseRequest) {
        log.info("[start] Create expense with id: " + idPeopleRegistered);
        ExpenseResponse expenseCreate = expenseService.createExpense(idPeopleRegistered, expenseRequest);
        log.info("[finished] Create expense with id: " + idPeopleRegistered);
        return expenseCreate;
    }

    @Override
    public List<ExpensePeopleListResponse> getExpensePeopleId(String idPeopleRegistered) {
        log.info("[start] List expense with id: " + idPeopleRegistered);
        List<ExpensePeopleListResponse> expensePeople = expenseService.searchPersonExpenseWithId(idPeopleRegistered);
        log.info("[finished] List expense with id: " + idPeopleRegistered);
        return expensePeople;
    }

    @Override
    public ExpenseDetailedResponse getExpensePeopleId(String idPeopleRegistered, String idExpense) {
        log.info("[start] List expense with id: " + idPeopleRegistered + " and idExpense: " + idExpense);
        ExpenseDetailedResponse expenseDetailed = expenseService.searchPersonExpenseWithId(idPeopleRegistered, idExpense);
        log.info("[finished] List expense with id: " + idPeopleRegistered + " and idExpense: " + idExpense);
        return expenseDetailed;
    }

    @Override
    public void deleteExpensePeopleId(String idPeopleRegistered, String idExpense) {
        log.info("[start] Delete expense with id: " + idPeopleRegistered + " and idExpense: " + idExpense);
        expenseService.deleteExpense(idPeopleRegistered, idExpense);
        log.info("[finished] Delete expense with id: " + idPeopleRegistered + " and idExpense: " + idExpense);
    }

    @Override
    public void updateExpensePeopleId(String idPeopleRegistered, String idExpense, ExpenseChangeRequest expenseChangeRequest) {
        log.info("[start] UpdateExpensePeopleId expense with id: " + idPeopleRegistered + " and idExpense: " + idExpense);
        expenseService.updateExpensePeopleWithId(idPeopleRegistered, idExpense, expenseChangeRequest);
        log.info("[finished] UpdateExpensePeopleId expense with id: " + idPeopleRegistered + " and idExpense: " + idExpense);
    }
}