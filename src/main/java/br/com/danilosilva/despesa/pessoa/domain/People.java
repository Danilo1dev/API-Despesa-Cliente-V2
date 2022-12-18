package br.com.danilosilva.despesa.pessoa.domain;

import br.com.danilosilva.despesa.despesa.domain.Expense;
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
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idPeople", updatable = false, unique = true, nullable = false)
    private UUID idPeople;

    @NotBlank
    @Column(unique = true)
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
    private String email;
    @NotNull
    private BigDecimal income;

    private LocalDateTime dateTimeRegistration;
    private LocalDateTime dateTimeLastChange;

    public People(String namePeople, List<Expense> expenses, String cpf, String age, Sex sex, String telephone, String email, BigDecimal income, LocalDateTime dateTimeRegistration) {
        this.namePeople = namePeople;
        this.expenses = expenses;
        this.cpf = cpf;
        this.age = age;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.income = income;
        this.dateTimeRegistration = LocalDateTime.now();
    }
}
