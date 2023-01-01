package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.pessoa.application.api.PeopleResponse;
import br.com.danilosilva.despesa.pessoa.application.mock.MockPeople;
import br.com.danilosilva.despesa.pessoa.application.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleApplicationServiceTest {

    @InjectMocks
    private PeopleApplicationService peopleService;
    @Mock
    private PeopleRepository peopleRepository;

    @Test
    void createPeople() {
        when(peopleRepository.save(any())).thenReturn(MockPeople.peopleBuild());
        PeopleResponse peopleResponse = peopleService.createPeople(MockPeople.peopleRequestBuild());
        assertNotNull(peopleResponse);
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