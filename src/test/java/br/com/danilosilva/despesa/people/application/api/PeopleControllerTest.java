package br.com.danilosilva.despesa.people.application.api;

import br.com.danilosilva.despesa.people.application.service.PeopleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PeopleControllerTest {
    @InjectMocks
    private PeopleController peopleController;
    @Mock
    private PeopleService peopleService;
    @Mock
    private PeopleRequest peopleRequest;
    @Mock
    private PeopleResponse peopleResponse;
    @Mock
    private PeopleListResponse peopleListResponse;
    @Mock
    private PeopleDetailedResponse peopleDetailedResponse;
    @Test
    void peopleCreate() {
        when(peopleService.createPeople(peopleRequest)).thenReturn(peopleResponse);
        peopleController.postPeople(peopleRequest);
        verify(peopleService).createPeople(peopleRequest);
        verify(peopleService,times (1)).createPeople(any());
        Assertions.assertNotNull(peopleResponse);
    }
    @Test
    void getEveryBody() {
        when(peopleService.searchAllPeople()).thenReturn(List.of(peopleListResponse));
        List<PeopleListResponse> peopleListResponses = peopleController.getEveryBody();
        verify(peopleService).searchAllPeople();
        verify(peopleService,times (1)).searchAllPeople();
        assertEquals(1,peopleListResponses.size());
    }
    @Test
    void getPersonViaID() {
        when(peopleService.getPersonViaID(any())).thenReturn(peopleDetailedResponse);
        PeopleDetailedResponse peopleDetailedResponse = peopleController.getPersonViaID(any());
        verify(peopleService).getPersonViaID(any());
        verify(peopleService,times (1)).getPersonViaID(any());
        Assertions.assertNotNull(peopleDetailedResponse);
    }
    @Test
    void deletePersonViaID() {
        peopleController.deletePersonViaID(UUID.randomUUID());
        verify(peopleService,times (1)).deletePersonViaID(any());
        Assertions.assertNotNull(peopleController);
    }
    @Test
    void changePeople() {
    }
}