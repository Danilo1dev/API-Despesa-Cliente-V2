package br.com.danilosilva.despesa.despesa.infra;

import br.com.danilosilva.despesa.despesa.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ExpenseSpringDataJPARepository extends JpaRepository<Expense, UUID> {
}
