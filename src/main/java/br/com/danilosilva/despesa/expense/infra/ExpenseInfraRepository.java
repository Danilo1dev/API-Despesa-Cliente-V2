package br.com.danilosilva.despesa.expense.infra;

import br.com.danilosilva.despesa.expense.application.repository.ExpenseRepository;
import br.com.danilosilva.despesa.expense.domain.Expense;
import br.com.danilosilva.despesa.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ExpenseInfraRepository implements ExpenseRepository {
    private final ExpenseSpringDataMongoRepository expenseSpringDataMongoRepository;

    @Override
    public Expense saveExpense(Expense expense) {
        log.info("[start] ExpenseInfraRepository - save");
        expenseSpringDataMongoRepository.save(expense);
        log.info("[finished] ExpenseInfraRepository - save");
        return expense;
    }

    @Override
    public List<Expense> searchExpenseOfPeopleId(UUID idPeopleRegistered) {
        log.info("[start] ExpenseInfraRepository - searchAllExpense");
        var expense = expenseSpringDataMongoRepository.findByIdPeopleRegistered(idPeopleRegistered);
        log.info("[finished] ExpenseInfraRepository - searchAllExpense");
        return expense;
    }

    @Override
    public Expense searchExpenseOfPeopleId(UUID idPeopleRegistered, UUID idExpense) {
        log.info("[start] ExpenseInfraRepository - searchExpenseOfPeopleId");
        var expense = expenseSpringDataMongoRepository.findById(idExpense)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Expense not found: " + idExpense));
        log.info("[finished] ExpenseInfraRepository - searchExpenseOfPeopleId");
        return expense;
    }

    @Override
    public void deleteExpense(Expense expense) {
        log.info("[start] ExpenseInfraRepository - deleteExpense");
        expenseSpringDataMongoRepository.delete(expense);
        log.info("[finished] ExpenseInfraRepository - deleteExpense");
    }
}
