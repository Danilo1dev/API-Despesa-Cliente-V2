package br.com.danilosilva.despesa.despesa.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idExpense", updatable = false, unique = true, nullable = false)
    private UUID idExpense;

    @NotNull
    @Column(columnDefinition = "uuid", name = "idPeopleRegistered", nullable = false)
    private UUID idPeopleRegistered;
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

    private LocalDateTime dateTimeRegistrationExpense;
    private LocalDateTime dateTimeLastChangeExpense;

    public Expense(String nameExpense, String description, BigDecimal price, ExpenseType expenseType, LocalDate expenseDate) {
        this.nameExpense = nameExpense;
        this.description = description;
        this.price = price;
        this.expenseType = expenseType;
        this.expenseDate = expenseDate;
        this.dateTimeRegistrationExpense = LocalDateTime.now();
    }
}
