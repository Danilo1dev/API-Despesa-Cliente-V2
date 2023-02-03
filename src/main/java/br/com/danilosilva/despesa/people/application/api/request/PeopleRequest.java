package br.com.danilosilva.despesa.people.application.api.request;

import br.com.danilosilva.despesa.people.domain.enums.Sex;
import lombok.Builder;
import lombok.Value;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@Builder
public class PeopleRequest {
    @NotBlank
    private String namePeople;
    @NotBlank
    private String cpf;
    @NotBlank
    private String age;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @NotBlank
    private String telephone;
    @Email
    private String email;
    @NotNull
    private BigDecimal income;
}
