package br.com.danilosilva.despesa.despesa.application.api;

import br.com.danilosilva.despesa.despesa.domain.Expense;
import br.com.danilosilva.despesa.despesa.domain.ExpenseType;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleDetailedResponse;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class ExpenseDetailedResponse {
    private UUID idExpense;
    private String nameExpense;
    private String description;
    private BigDecimal price;
    private ExpenseType expenseType;
    private LocalDate expenseDate;

    public ExpenseDetailedResponse(Expense expense, PeopleDetailedResponse getPeopleViaID) {
        this.idExpense = expense.getIdExpense();
        this.nameExpense = expense.getNameExpense();
        this.description = expense.getDescription();
        this.price = expense.getPrice();
        this.expenseType = expense.getExpenseType();
        this.expenseDate = expense.getExpenseDate();
    }
}