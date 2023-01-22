package br.com.danilosilva.despesa.people.application.mock;

import br.com.danilosilva.despesa.people.application.api.ChangePeopleRequest;
import br.com.danilosilva.despesa.people.application.api.PeopleRequest;
import br.com.danilosilva.despesa.people.application.api.PeopleResponse;
import br.com.danilosilva.despesa.people.domain.People;
import br.com.danilosilva.despesa.people.domain.Sex;
import lombok.Builder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class MockPeople {

    public static People peopleBuild() {
        return People.builder()
                .idPeople(UUID.randomUUID().toString())
                .namePeople("Danilo Silva")
                .cpf("12345678901")
                .age("30")
                .sex(Sex.valueOf("MASCULINE"))
                .telephone("73981978258")
                .email("danilo@email.com")
                .income(new BigDecimal("1000.00"))
                .dateTimeRegistration(LocalDateTime.now())
                .build();
    }

    public static PeopleRequest peopleRequestBuild() {
        return PeopleRequest.builder()
              .namePeople("Danilo Silva")
              .cpf("12345678901")
              .age("30")
              .sex(Sex.valueOf("MASCULINE"))
              .telephone("73981978258")
              .email("danilo@email.com")
              .income(new BigDecimal("1000.00"))
              .build();
    }

    public static ChangePeopleRequest changePeopleRequestBuild() {
        return ChangePeopleRequest.builder()
              .namePeople("Danilo Silva Ferreira")
              .age("33")
              .sex(Sex.valueOf("FEMININE"))
              .telephone("73981978259")
              .income(new BigDecimal("1000.00"))
              .build();
    }
    public static PeopleResponse peopleResponseBuild() {
        return PeopleResponse.builder()
                .idPeople(UUID.randomUUID().toString())
                .build();
    }
}
