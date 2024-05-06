package br.com.transferencia.transferencia.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TransferRequest {

	private String accountTarget;
	
	private String accountOrigin;
	
	private BigDecimal transferValue;
	
	private LocalDate schedulingDate;
}
