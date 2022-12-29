package br.com.danilosilva.despesa.despesa.infra;

import br.com.danilosilva.despesa.despesa.application.repository.ExpenseRepository;
import br.com.danilosilva.despesa.despesa.domain.Expense;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
