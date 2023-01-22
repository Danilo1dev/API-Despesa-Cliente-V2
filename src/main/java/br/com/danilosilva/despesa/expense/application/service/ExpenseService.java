package br.com.danilosilva.despesa.expense.application.service;

import br.com.danilosilva.despesa.expense.application.api.*;
import java.util.List;

public interface ExpenseService {
    ExpenseResponse createExpense(String idPeopleRegistered, ExpenseRequest expenseRequest);
    List<ExpensePeopleListResponse> searchPersonExpenseWithId(String idPeopleRegistered);
    ExpenseDetailedResponse searchPersonExpenseWithId(String idPeopleRegistered, String idExpense);
    void deleteExpense(String idPeopleRegistered, String idExpense);
    void updateExpensePeopleWithId(String idPeopleRegistered, String idExpense, ExpenseChangeRequest expenseChangeRequest);
}
