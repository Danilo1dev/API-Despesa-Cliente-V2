package br.com.danilosilva.despesa.expense.application.api.response;

import br.com.danilosilva.despesa.expense.domain.entity.Expense;
import br.com.danilosilva.despesa.expense.domain.enums.ExpenseType;
import br.com.danilosilva.despesa.people.application.api.response.PeopleDetailedResponse;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class ExpenseDetailedResponse {
    private String idExpense;
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
