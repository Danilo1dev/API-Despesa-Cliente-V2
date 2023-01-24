package br.com.danilosilva.despesa.expense.domain;

import br.com.danilosilva.despesa.expense.application.api.ExpenseChangeRequest;
import br.com.danilosilva.despesa.expense.application.api.ExpenseRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "expense")
public class Expense {
    @Id
    private String idExpense;
    @Indexed
    @NotNull
    private String idPeopleRegistered;

//    @DocumentReference(lazy = true, db = "people")
//    @ReadOnlyProperty
//    private People people;

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
    private LocalDate expenseDate;

    private LocalDateTime dateTimeRegistrationExpense;
    private LocalDateTime dateTimeLastChangeExpense;

    public Expense(String idPeopleRegistered, ExpenseRequest expenseRequest) {
        this.idPeopleRegistered = idPeopleRegistered;
        this.nameExpense = expenseRequest.getNameExpense();
        this.description = expenseRequest.getDescription();
        this.price = expenseRequest.getPrice();
        this.expenseType = expenseRequest.getExpenseType();
        this.expenseDate = expenseRequest.getExpenseDate();
        this.dateTimeRegistrationExpense = LocalDateTime.now();
    }
    public void updateExpense(ExpenseChangeRequest expenseChangeRequest) {
        this.nameExpense = expenseChangeRequest.getNameExpense();
        this.description = expenseChangeRequest.getDescription();
        this.price = expenseChangeRequest.getPrice();
        this.expenseType = expenseChangeRequest.getExpenseType();
        this.expenseDate = expenseChangeRequest.getExpenseDate();
        this.dateTimeLastChangeExpense = LocalDateTime.now();
    }
}
