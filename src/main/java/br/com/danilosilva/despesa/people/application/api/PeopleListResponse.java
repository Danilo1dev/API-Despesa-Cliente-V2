package br.com.danilosilva.despesa.people.application.api;

import br.com.danilosilva.despesa.people.domain.People;
import lombok.Value;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class PeopleListResponse {
    private String idPeople;
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
