package br.com.danilosilva.despesa.pessoa.application.api;

import br.com.danilosilva.despesa.pessoa.domain.People;
import lombok.Value;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PeopleListResponse {
    private UUID idPeople;
    private String namePeople;
    private String cpf;
    private String telephone;
    private String email;

    public static List<PeopleListResponse> converte(List<People> peoples) {
        return peoples.stream()
                .map(PeopleListResponse::new)
                .collect(Collectors.toList());
    }

    public PeopleListResponse(People people) {
        this.idPeople = people.getIdPeople();
        this.namePeople = people.getNamePeople();
        this.cpf = people.getCpf();
        this.telephone = people.getTelephone();
        this.email = people.getEmail();
    }
}
