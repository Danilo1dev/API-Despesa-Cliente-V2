package br.com.danilosilva.despesa.people.application.service;

import br.com.danilosilva.despesa.people.application.api.PeopleDetailedResponse;
import br.com.danilosilva.despesa.people.application.api.PeopleListResponse;
import br.com.danilosilva.despesa.people.application.api.PeopleResponse;
import br.com.danilosilva.despesa.people.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.people.application.mock.MockPeople;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.UUID;
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
        PeopleDetailedResponse peopleResponse = peopleService.getPersonViaID(UUID.randomUUID());
        assertNotNull(peopleResponse);
    }
    @Test
    void deletePersonViaIDSuccess() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        peopleService.deletePersonViaID(UUID.randomUUID());
        assertNotNull(peopleService);
    }
    @Test
    void changePersonViaIDSuccess() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        peopleService.changePersonViaID(UUID.randomUUID(), MockPeople.changePeopleRequestBuild());
        assertNotNull(peopleService);
    }
}