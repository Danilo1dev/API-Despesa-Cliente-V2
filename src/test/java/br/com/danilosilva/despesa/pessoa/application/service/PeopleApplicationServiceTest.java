package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.pessoa.application.mock.MockPeople;
import br.com.danilosilva.despesa.pessoa.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.pessoa.domain.People;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleApplicationServiceTest {

    @InjectMocks
    private PeopleApplicationService peopleApplicationService;

    @Mock
    private PeopleRepository peopleRepository;

    @Test
    void createPeople() {
        when(peopleRepository.save(any(People.class))).thenReturn(MockPeople.peopleBuild());
    }

    @Test
    void searchAllPeople() {
    }

    @Test
    void getPersonViaID() {
    }

    @Test
    void deletePersonViaID() {
    }

    @Test
    void changePersonViaID() {
    }
}