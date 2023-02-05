package br.com.danilosilva.despesa.people.infra;

import br.com.danilosilva.despesa.handler.APIException;
import br.com.danilosilva.despesa.people.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.people.domain.entity.People;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PeopleInfraRepository implements PeopleRepository {
    private final PeopleSpringDataMongoRepository peopleSpringDataMongoRepository;

    @Override
    public People save(People people) {
        log.info("[start] PeopleInfraRepository - savePeople");
        try {
            peopleSpringDataMongoRepository.save(people);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Email or CPF already registered",e);
        }
        log.info("[finished] PeopleInfraRepository - savePeople");
        return people;
    }

    @Override
    public List<People> searchAllPeople() {
        log.info("[start] PeopleInfraRepository - searchAllPeople");
        List<People> everybody = peopleSpringDataMongoRepository.findAll();
        log.info("[finished] PeopleInfraRepository - searchAllPeople");
        return everybody;
    }

    @Override
    public People searchPersonById(String idPeople) {
        log.info("[start]PeopleInfraRepository - searchPersonById");
        People people = peopleSpringDataMongoRepository.findById(idPeople)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Person not Found: " + idPeople));
        log.info("[finished]PeopleInfraRepository - searchPersonById");
        return people;
    }

    @Override
    public void deletePeople(People people) {
        log.info("[start]PeopleInfraRepository - deletePeople");
        peopleSpringDataMongoRepository.delete(people);
        log.info("[finished]PeopleInfraRepository - deletePeople");
    }
}
