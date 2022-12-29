package br.com.danilosilva.despesa.despesa.application.service;

import br.com.danilosilva.despesa.despesa.application.api.ExpenseRequest;
import br.com.danilosilva.despesa.despesa.application.api.ExpenseResponse;
import java.util.UUID;

public interface ExpenseService {
    ExpenseResponse createExpense(UUID idPeopleRegistered, ExpenseRequest expenseRequest);
}