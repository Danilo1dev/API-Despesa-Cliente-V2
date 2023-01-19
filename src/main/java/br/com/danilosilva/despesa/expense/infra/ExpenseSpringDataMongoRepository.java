package br.com.danilosilva.despesa.expense.infra;

import br.com.danilosilva.despesa.expense.domain.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.UUID;

public interface ExpenseSpringDataMongoRepository extends MongoRepository<Expense, UUID> {
    List<Expense> findByIdPeopleRegistered(UUID idPeopleRegistered);
}
