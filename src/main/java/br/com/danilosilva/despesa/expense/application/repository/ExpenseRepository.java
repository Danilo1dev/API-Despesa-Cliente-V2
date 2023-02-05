package br.com.danilosilva.despesa.expense.application.repository;

import br.com.danilosilva.despesa.expense.domain.entity.Expense;
import java.util.List;

public interface ExpenseRepository {
    Expense saveExpense(Expense expense);
    List<Expense> searchExpenseOfPeopleId(String idPeopleRegistered);
    Expense searchExpenseOfPeopleId(String idPeopleRegistered, String idExpense);
    void deleteExpense(Expense expense);
}
