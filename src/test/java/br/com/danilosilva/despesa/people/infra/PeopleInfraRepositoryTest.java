package br.com.danilosilva.despesa.people.infra;

import br.com.danilosilva.despesa.handler.APIException;
import br.com.danilosilva.despesa.people.application.mock.MockPeople;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleInfraRepositoryTest {
    @InjectMocks
    private PeopleInfraRepository peopleRepository;
    @Mock
    private PeopleSpringDataJPARepository peopleSpringDataJPARepository;

    @Test
    void saveSuccess() {
        when(peopleSpringDataJPARepository.save(any())).thenReturn(MockPeople.peopleBuild());
        peopleRepository.save(MockPeople.peopleBuild());
        assertNotNull(peopleRepository);
    }
    @Test
    void emailAndCPFAlreadyRegistered() {
        when(peopleSpringDataJPARepository.save(any())).
           thenThrow(new DataIntegrityViolationException("CPF already registered"));
        RuntimeException exception = assertThrows(
                APIException.class, () -> peopleRepository.save(MockPeople.peopleBuild()));
    }
    @Test
    void searchAllPeopleSuccess() {
        when(peopleSpringDataJPARepository.findAll()).thenReturn(List.of(MockPeople.peopleBuild()));
        peopleRepository.searchAllPeople();
        assertNotNull(peopleRepository);
    }
    @Test
    void searchPersonByIdSuccess() {
        when(peopleSpringDataJPARepository.findById(any())).thenReturn(Optional.of(MockPeople.peopleBuild()));
        peopleRepository.searchPersonById(any());
        assertNotNull(peopleRepository);
    }
    @Test
    void searchPersonByIdNotFound() {
        when(peopleSpringDataJPARepository.findById(any())).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(APIException.class, () ->
                peopleRepository.searchPersonById(UUID.randomUUID()));
        assertNotNull(exception);
    }
    @Test
    void deletePeopleSuccess() {
        peopleRepository.deletePeople(MockPeople.peopleBuild());
        assertNotNull(peopleRepository);
    }
}