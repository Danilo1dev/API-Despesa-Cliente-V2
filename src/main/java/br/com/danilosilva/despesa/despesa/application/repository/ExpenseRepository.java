package br.com.danilosilva.despesa.despesa.application.repository;

import br.com.danilosilva.despesa.despesa.domain.Expense;
import java.util.List;
import java.util.UUID;

public interface ExpenseRepository {
    Expense saveExpense(Expense expense);
    List<Expense> searchExpenseOfPeopleId(UUID idPeopleRegistered);
    Expense searchExpenseOfPeopleId(UUID idPeopleRegistered, UUID idExpense);
}
