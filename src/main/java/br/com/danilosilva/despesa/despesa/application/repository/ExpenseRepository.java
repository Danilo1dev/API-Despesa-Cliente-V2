package br.com.danilosilva.despesa.despesa.application.repository;

import br.com.danilosilva.despesa.despesa.domain.Expense;

public interface ExpenseRepository {
    Expense saveExpense(Expense expense);
}
