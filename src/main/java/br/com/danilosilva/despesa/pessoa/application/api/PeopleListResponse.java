package br.com.danilosilva.despesa.pessoa.application.api;

import lombok.Value;
import java.util.UUID;

@Value
public class PeopleListResponse {
    private UUID idPeople;
    private String namePeople;
    private String cpf;
    private String telephone;
    private String email;
}
