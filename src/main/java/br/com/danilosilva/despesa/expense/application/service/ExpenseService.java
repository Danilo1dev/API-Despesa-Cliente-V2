package br.com.danilosilva.despesa.expense.application.service;

import br.com.danilosilva.despesa.expense.application.api.*;
import java.util.List;
import java.util.UUID;

public interface ExpenseService {
    ExpenseResponse createExpense(UUID idPeopleRegistered, ExpenseRequest expenseRequest);
    List<ExpensePeopleListResponse> searchPersonExpenseWithId(UUID idPeopleRegistered);
    ExpenseDetailedResponse searchPersonExpenseWithId(UUID idPeopleRegistered, UUID idExpense);
    void deleteExpense(UUID idPeopleRegistered, UUID idExpense);
    void updateExpensePeopleWithId(UUID idPeopleRegistered, UUID idExpense, ExpenseChangeRequest expenseChangeRequest);
}
