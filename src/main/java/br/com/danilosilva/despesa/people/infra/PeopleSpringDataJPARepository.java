package br.com.danilosilva.despesa.people.infra;

import br.com.danilosilva.despesa.people.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PeopleSpringDataJPARepository extends JpaRepository <People, UUID>{
}
