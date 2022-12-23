package br.com.danilosilva.despesa.pessoa.application.api;

import br.com.danilosilva.despesa.pessoa.domain.People;
import lombok.Value;
import java.util.List;
import java.util.UUID;

@Value
public class PeopleListResponse {
    private UUID idPeople;
    private String namePeople;
    private String cpf;
    private String telephone;
    private String email;

    public static List<PeopleListResponse> converte(List<People> peoples) {
        return null;
    }
}
