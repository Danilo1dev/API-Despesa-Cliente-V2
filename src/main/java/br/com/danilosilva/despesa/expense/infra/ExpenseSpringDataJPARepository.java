package br.com.danilosilva.despesa.expense.infra;

import br.com.danilosilva.despesa.expense.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ExpenseSpringDataJPARepository extends JpaRepository<Expense, UUID> {
    List<Expense> findByIdPeopleRegistered(UUID idPeopleRegistered);
}
