package br.com.danilosilva.despesa.despesa.application.service;

import br.com.danilosilva.despesa.despesa.application.api.ExpenseDetailedResponse;
import br.com.danilosilva.despesa.despesa.application.api.ExpensePeopleListResponse;
import br.com.danilosilva.despesa.despesa.application.api.ExpenseRequest;
import br.com.danilosilva.despesa.despesa.application.api.ExpenseResponse;
import java.util.List;
import java.util.UUID;

public interface ExpenseService {
    ExpenseResponse createExpense(UUID idPeopleRegistered, ExpenseRequest expenseRequest);
    List<ExpensePeopleListResponse> searchPersonExpenseWithId(UUID idPeopleRegistered);
    ExpenseDetailedResponse searchPersonExpenseWithId(UUID idPeopleRegistered, UUID idExpense);
}
