package br.com.danilosilva.despesa.despesa.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;
    private LocalDate expenseDate;

    private LocalDateTime dateTimeRegistrationExpense;
    private LocalDateTime dateTimeLastChangeExpense;
}
