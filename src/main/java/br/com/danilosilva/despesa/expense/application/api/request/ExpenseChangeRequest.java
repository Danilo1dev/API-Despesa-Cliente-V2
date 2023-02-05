package br.com.danilosilva.despesa.expense.application.api.request;

import br.com.danilosilva.despesa.expense.domain.enums.ExpenseType;
import lombok.Value;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class ExpenseChangeRequest {
    @NotNull
    private String nameExpense;
    @NotNull
    @NotBlank(message = "Enter a Description")
    @Size(max = 100)
    private String description;
    @NotNull
    private BigDecimal price;
    private ExpenseType expenseType;
    private LocalDate expenseDate;
}
