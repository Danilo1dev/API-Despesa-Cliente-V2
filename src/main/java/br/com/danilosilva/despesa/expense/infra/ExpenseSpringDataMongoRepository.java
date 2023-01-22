package br.com.danilosilva.despesa.expense.infra;

import br.com.danilosilva.despesa.expense.domain.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ExpenseSpringDataMongoRepository extends MongoRepository<Expense, String> {
    List<Expense> findByIdPeopleRegistered(String idPeopleRegistered);
}
