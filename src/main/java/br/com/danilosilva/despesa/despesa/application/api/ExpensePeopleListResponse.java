package br.com.danilosilva.despesa.despesa.application.api;

import br.com.danilosilva.despesa.despesa.domain.Expense;
import br.com.danilosilva.despesa.despesa.domain.ExpenseType;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ExpensePeopleListResponse {
    private UUID idExpense;
    private String nameExpense;
    private String description;
    private BigDecimal price;
    private ExpenseType expenseType;
    private LocalDate expenseDate;
    private LocalDateTime dateTimeRegistrationExpense;

    public static List<ExpensePeopleListResponse> converte(List<Expense> expensePeople) {
        return null;
    }
}
