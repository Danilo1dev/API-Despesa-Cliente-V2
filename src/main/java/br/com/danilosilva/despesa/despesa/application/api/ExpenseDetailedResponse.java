package br.com.danilosilva.despesa.despesa.application.api;

import br.com.danilosilva.despesa.despesa.domain.ExpenseType;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseDetailedResponse {
    private String nameExpense;
    private String description;
    private BigDecimal price;
    private ExpenseType expenseType;
    private LocalDate expenseDate;
}
