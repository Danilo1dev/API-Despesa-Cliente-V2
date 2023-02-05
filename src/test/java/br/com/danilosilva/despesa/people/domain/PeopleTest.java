package br.com.danilosilva.despesa.people.domain;

import br.com.danilosilva.despesa.people.application.mock.MockPeople;
import br.com.danilosilva.despesa.people.application.repository.PeopleRepository;
import br.com.danilosilva.despesa.people.domain.entity.People;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleTest {
    @InjectMocks
    private People people;
    @Mock
    private PeopleRepository peopleRepository;
    @Test
    void getNamePeople() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        People people = peopleRepository.searchPersonById(any());
        assertNotNull(people);
    }
    @Test
    void getCpf() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        People people = peopleRepository.searchPersonById(any());
        assertNotNull(people);
        assertNotNull(people.getCpf());
    }
    @Test
    void getAge() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        People people = peopleRepository.searchPersonById(any());
        assertNotNull(people);
        assertNotNull(people.getAge());
    }
    @Test
    void getSex() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        People people = peopleRepository.searchPersonById(any());
        assertNotNull(people);
        assertNotNull(people.getSex());
    }
    @Test
    void getTelephone() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        People people = peopleRepository.searchPersonById(any());
        assertNotNull(people);
        assertNotNull(people.getTelephone());
    }
    @Test
    void getEmail() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        People people = peopleRepository.searchPersonById(any());
        assertNotNull(people);
        assertNotNull(people.getEmail());
    }
    @Test
    void getIncome() {
        when(peopleRepository.searchPersonById(any())).thenReturn(MockPeople.peopleBuild());
        People people = peopleRepository.searchPersonById(any());
        assertNotNull(people);
        assertNotNull(people.getIncome());
    }
}