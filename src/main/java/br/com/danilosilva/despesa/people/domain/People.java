package br.com.danilosilva.despesa.people.domain;

import br.com.danilosilva.despesa.expense.domain.Expense;
import br.com.danilosilva.despesa.people.application.api.ChangePeopleRequest;
import br.com.danilosilva.despesa.people.application.api.PeopleRequest;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "people")
public class People {
    @Id
    private UUID idPeople;
    @NotBlank
    private String namePeople;

    @DBRef(db = "expense")
    private List<Expense> expenses;

    @NotBlank
    @Size(max = 11)
    @Indexed(unique = true)
    private String cpf;
    @NotBlank
    @Size(max = 2)
    private String age;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @NotBlank
    private String telephone;
    @Email
    @Indexed(unique = true)
    private String email;
    @NotNull
    private BigDecimal income;

    private LocalDateTime dateTimeRegistration;
    private LocalDateTime dateTimeLastChange;

    public People(PeopleRequest peopleRequest) {
        this.namePeople = peopleRequest.getNamePeople();
        this.cpf = peopleRequest.getCpf();
        this.age = peopleRequest.getAge();
        this.sex = peopleRequest.getSex();
        this.telephone = peopleRequest.getTelephone();
        this.email = peopleRequest.getEmail();
        this.income = peopleRequest.getIncome();
        this.dateTimeRegistration = LocalDateTime.now();
    }

    public void change(ChangePeopleRequest peopleRequest) {
        this.namePeople = peopleRequest.getNamePeople();
        this.age = peopleRequest.getAge();
        this.sex = peopleRequest.getSex();
        this.telephone = peopleRequest.getTelephone();
        this.income = peopleRequest.getIncome();
        this.dateTimeLastChange = LocalDateTime.now();
    }
}
