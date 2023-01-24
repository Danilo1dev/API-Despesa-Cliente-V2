package br.com.danilosilva.despesa.people.application.api;

import br.com.danilosilva.despesa.expense.domain.ExpenseType;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class ExpenseListResponsePeople {
    private String idExpense;
    private String nameExpense;
    private String description;
    private BigDecimal price;
    private ExpenseType expenseType;
    private LocalDate expenseDate;
    private LocalDateTime dateTimeRegistrationExpense;
}
