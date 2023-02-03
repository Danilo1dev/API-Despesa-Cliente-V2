package br.com.danilosilva.despesa.people.application.api.response;

import br.com.danilosilva.despesa.people.domain.entity.People;
import br.com.danilosilva.despesa.people.domain.enums.Sex;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class PeopleDetailedResponse {
    private String idPeople;
    private String namePeople;
    private String age;
    private Sex sex;
    private String cpf;
    private String telephone;
    private String email;
    private BigDecimal income;
    private LocalDateTime dateTimeRegistration;

    public PeopleDetailedResponse(People people) {
        this.idPeople = people.getIdPeople();
        this.namePeople = people.getNamePeople();
        this.age = people.getAge();
        this.sex = people.getSex();
        this.cpf = people.getCpf();
        this.telephone = people.getTelephone();
        this.email = people.getEmail();
        this.income = people.getIncome();
        this.dateTimeRegistration = people.getDateTimeRegistration();
    }
}
