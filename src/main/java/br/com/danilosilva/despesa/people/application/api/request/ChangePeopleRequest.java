package br.com.danilosilva.despesa.people.application.api.request;

import br.com.danilosilva.despesa.people.domain.enums.Sex;
import lombok.Builder;
import lombok.Value;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@Builder
public class ChangePeopleRequest {
        @NotBlank
        private String namePeople;
        @NotBlank
        private String age;
        @Enumerated(EnumType.STRING)
        private Sex sex;
        @NotBlank
        private String telephone;
        @NotNull
        private BigDecimal income;
}

