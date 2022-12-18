package br.com.danilosilva.despesa.pessoa.infra;

import br.com.danilosilva.despesa.pessoa.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.pessoa.domain.People;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PeopleInfraRepository implements PeopleRepository {
    private final PeopleSpringDataJPARepository peopleSpringDataJPARepository;

    @Override
    public People save(People people) {
        log.info("[start] PeopleInfraRepository - savePeople");
        peopleSpringDataJPARepository.save(people);
        log.info("[finished] PeopleInfraRepository - savePeople");
        return people;
    }
}
