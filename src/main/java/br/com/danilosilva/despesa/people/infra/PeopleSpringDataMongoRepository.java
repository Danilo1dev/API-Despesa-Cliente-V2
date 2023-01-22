package br.com.danilosilva.despesa.people.infra;

import br.com.danilosilva.despesa.people.domain.People;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleSpringDataMongoRepository extends MongoRepository <People, String> {
}
