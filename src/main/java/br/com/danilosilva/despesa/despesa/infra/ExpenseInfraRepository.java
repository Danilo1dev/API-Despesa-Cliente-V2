package br.com.danilosilva.despesa.despesa.infra;

import br.com.danilosilva.despesa.despesa.application.repository.ExpenseRepository;
import br.com.danilosilva.despesa.despesa.domain.Expense;
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
    private final ExpenseSpringDataJPARepository expenseSpringDataJPARepository;

    @Override
    public Expense saveExpense(Expense expense) {
        log.info("[start] ExpenseInfraRepository - save");
        expenseSpringDataJPARepository.save(expense);
        log.info("[finished] ExpenseInfraRepository - save");
        return expense;
    }

    @Override
    public List<Expense> searchExpenseOfPeopleId(UUID idPeopleRegistered) {
        log.info("[start] ExpenseInfraRepository - searchAllExpense");
        var expense = expenseSpringDataJPARepository.findByIdPeopleRegistered(idPeopleRegistered);
        log.info("[finished] ExpenseInfraRepository - searchAllExpense");
        return expense;
    }

    @Override
    public Expense searchExpenseOfPeopleId(UUID idPeopleRegistered, UUID idExpense) {
        log.info("[start] ExpenseInfraRepository - searchExpenseOfPeopleId");
        var expense = expenseSpringDataJPARepository.findById(idExpense)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Expense not found: " + idExpense));
        log.info("[finished] ExpenseInfraRepository - searchExpenseOfPeopleId");
        return expense;
    }

    @Override
    public void deleteExpense(Expense expense) {
        log.info("[start] ExpenseInfraRepository - deleteExpense");
        expenseSpringDataJPARepository.delete(expense);
        log.info("[finished] ExpenseInfraRepository - deleteExpense");
    }
}
