package br.com.danilosilva.despesa.people.application.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PeopleResponse {
    private String idPeople;
}
