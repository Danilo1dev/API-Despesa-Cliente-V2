package br.com.danilosilva.despesa.despesa.application.api;

import lombok.Value;
import java.util.UUID;
@Value
public class ExpenseResponse {
    private UUID idExpense;
}
