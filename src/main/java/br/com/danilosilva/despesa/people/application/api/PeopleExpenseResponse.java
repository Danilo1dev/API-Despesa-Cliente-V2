package br.com.danilosilva.despesa.people.application.api;

import br.com.danilosilva.despesa.expense.domain.Expense;
import br.com.danilosilva.despesa.expense.domain.ExpenseType;
import br.com.danilosilva.despesa.people.domain.People;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class PeopleExpenseResponse {
    private String idExpense;
    private String nameExpense;
    private String description;
    private BigDecimal price;
    private ExpenseType expenseType;
    private LocalDate expenseDate;
    private LocalDateTime dateTimeRegistrationExpense;

    public static List<PeopleExpenseResponse> converte(List<Expense> byIdPeopleRegistered) {
        return byIdPeopleRegistered.stream()
                .map(expense -> new PeopleExpenseResponse(expense.getPeople(), expense))
                .collect(Collectors.toList());
    }

    public PeopleExpenseResponse(People people, Expense expense) {

        this.idExpense = expense.getIdExpense();
        this.nameExpense = expense.getNameExpense();
        this.description = expense.getDescription();
        this.price = expense.getPrice();
        this.expenseType = expense.getExpenseType();
        this.expenseDate = expense.getExpenseDate();
        this.dateTimeRegistrationExpense = expense.getDateTimeRegistrationExpense();
    }
}
