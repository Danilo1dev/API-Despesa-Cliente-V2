package br.com.danilosilva.despesa.pessoa.application.api;

import lombok.Builder;
import lombok.Value;
import java.util.UUID;

@Value
@Builder
public class PeopleResponse {
    private UUID idPeople;
}
