package br.com.danilosilva.despesa.pessoa.application.service;

import br.com.danilosilva.despesa.handler.APIException;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleDetailedResponse;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleResponse;
import br.com.danilosilva.despesa.pessoa.application.mock.MockPeople;
import br.com.danilosilva.despesa.pessoa.application.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleApplicationServiceTest {

    @InjectMocks
    private PeopleApplicationService peopleService;
    @Mock
    private PeopleRepository peopleRepository;

    @Test
    void TestCreatePeopleSucess() {
        when(peopleRepository.save(any())).thenReturn(MockPeople.peopleBuild());
        PeopleResponse peopleResponse = peopleService.createPeople(MockPeople.peopleRequestBuild());
        assertNotNull(peopleResponse);
    }

    @Test
    void TestGetPersonViaIDSuccess() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        PeopleDetailedResponse peopleResponse = peopleService.getPersonViaID(UUID.randomUUID());
        assertNotNull(peopleResponse);
    }

    @Test
    void TestGetPersonViaIDNotFound() {
        when(peopleRepository.searchPersonById(any())).thenReturn(null);
        APIException exception = assertThrows(APIException.class, () -> peopleService.getPersonViaID(UUID.randomUUID()));
        assertNotNull(exception);
        assertEquals(exception.getMessage(), "Person not found");
    }

    @Test
    void searchAllPeople() {

    }

    @Test
    void deletePersonViaID() {
    }

    @Test
    void updatePersonViaID() {
    }

    @Test
    void changePersonViaID() {
    }
}