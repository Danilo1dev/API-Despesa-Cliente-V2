package br.com.danilosilva.despesa.pessoa.application.api;

import br.com.danilosilva.despesa.pessoa.domain.Sex;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Value
public class DetailedPersonResponse {
    private UUID idPeople;
    private String namePeople;
    private String age;
    private Sex sex;
    private String cpf;
    private String telephone;
    private String email;
    private BigDecimal income;
    private LocalDateTime dateTimeRegistration;
}
