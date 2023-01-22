package br.com.danilosilva.despesa.people.application.service;

import br.com.danilosilva.despesa.people.application.api.PeopleDetailedResponse;
import br.com.danilosilva.despesa.people.application.api.PeopleListResponse;
import br.com.danilosilva.despesa.people.application.api.PeopleResponse;
import br.com.danilosilva.despesa.people.application.mock.MockPeople;
import br.com.danilosilva.despesa.people.application.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
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
    void searchAllPeopleListSuccess() {
        when(peopleRepository.searchAllPeople()).thenReturn(List.of(MockPeople.peopleBuild()));
        List<PeopleListResponse> peopleListResponses = peopleService.searchAllPeople();
        assertNotNull(peopleListResponses);
    }
    @Test
    void getPersonViaIDSuccess() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        PeopleDetailedResponse peopleResponse = peopleService.getPersonViaID(UUID.randomUUID().toString());
        assertNotNull(peopleResponse);
    }
    @Test
    void getPersonViaIDNotFound() {
        when(peopleRepository.searchPersonById(any())).thenThrow(new RuntimeException("Person not found"));
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                peopleService.getPersonViaID(UUID.randomUUID().toString()));
        assertNotNull(exception);
        assertEquals("Person not found", exception.getMessage());
    }

    @Test
    void deletePersonViaIDSuccess() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        peopleService.deletePersonViaID(UUID.randomUUID().toString());
        assertNotNull(peopleService);
    }
    @Test
    void changePersonViaIDSuccess() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        peopleService.changePersonViaID(UUID.randomUUID().toString(), MockPeople.changePeopleRequestBuild());
        assertNotNull(peopleService);
    }
}