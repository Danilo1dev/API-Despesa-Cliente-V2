package br.com.danilosilva.despesa.despesa.infra;

import br.com.danilosilva.despesa.despesa.application.repository.ExpenseRepository;
import br.com.danilosilva.despesa.despesa.domain.Expense;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        log.info("[start] InfraRepository - save");
        expenseSpringDataJPARepository.save(expense);
        log.info("[finished] InfraRepository - save");
        return expense;
    }

    @Override
    public List<Expense> searchExpenseOfPeopleWithId(UUID idPeopleRegistered) {
        log.info("[start] InfraRepository - searchAllExpense");
        var expense = expenseSpringDataJPARepository.findByIdPeopleRegistered(idPeopleRegistered);
        log.info("[finished] InfraRepository - searchAllExpense");
        return expense;
    }
}
