package br.com.danilosilva.despesa.expense.infra;

import br.com.danilosilva.despesa.expense.domain.entity.Expense;
import br.com.danilosilva.despesa.people.domain.entity.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ExpenseSpringDataMongoRepository extends MongoRepository<Expense, String> {
    List<Expense> findByIdPeopleRegistered(String idPeopleRegistered);
    List<Expense> findByPeople(People people);
}
