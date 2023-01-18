package br.com.danilosilva.despesa.expense.application.repository;

import br.com.danilosilva.despesa.expense.domain.Expense;
import java.util.List;
import java.util.UUID;

public interface ExpenseRepository {
    Expense saveExpense(Expense expense);
    List<Expense> searchExpenseOfPeopleId(UUID idPeopleRegistered);
    Expense searchExpenseOfPeopleId(UUID idPeopleRegistered, UUID idExpense);
    void deleteExpense(Expense expense);
}
