package br.com.danilosilva.despesa.pessoa.infra;

import br.com.danilosilva.despesa.pessoa.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PeopleSpringDataJPARepository extends JpaRepository <People, UUID>{
}
