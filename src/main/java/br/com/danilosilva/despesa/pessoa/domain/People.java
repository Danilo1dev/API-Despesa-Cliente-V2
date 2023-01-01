package br.com.danilosilva.despesa.pessoa.domain;

import br.com.danilosilva.despesa.despesa.domain.Expense;
import br.com.danilosilva.despesa.pessoa.application.api.ChangePeopleRequest;
import br.com.danilosilva.despesa.pessoa.application.api.PeopleRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idPeople", updatable = false, unique = true, nullable = false)
    private UUID idPeople;

    @NotBlank
    private String namePeople;

    @OneToMany (mappedBy = "people")
    private List<Expense> expenses;

    @NotBlank
    @Size(max = 11)
    @Column(unique = true)
    private String cpf;
    @NotBlank
    @Size(max = 2)
    private String age;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @NotBlank
    private String telephone;
    @Email
    @Column(unique = true)
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
