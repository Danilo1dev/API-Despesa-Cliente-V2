package br.com.danilosilva.despesa.people.application.api;

import br.com.danilosilva.despesa.people.application.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    @Test
    void peopleCreate() {
        when(peopleService.createPeople(peopleRequest)).thenReturn(peopleResponse);
        peopleController.postPeople(peopleRequest);
        verify(peopleService).createPeople(peopleRequest);
    }
    @Test
    void getEveryBody() {
    }

    @Test
    void getPersonViaID() {
    }

    @Test
    void deletePersonViaID() {
    }

    @Test
    void changePeople() {
    }
}