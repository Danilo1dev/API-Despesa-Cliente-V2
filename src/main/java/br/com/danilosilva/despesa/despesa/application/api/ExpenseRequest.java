package br.com.danilosilva.despesa.despesa.application.api;

import br.com.danilosilva.despesa.despesa.domain.ExpenseType;
import lombok.Value;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class ExpenseRequest {

    @NotNull
    private String nameExpense;
    @NotNull
    @NotBlank(message = "Enter a Description")
    @Size(max = 100)
    private String description;
    @NotNull
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;
    @NotNull
    private LocalDate expenseDate;
}
