package br.com.transferencia.transferencia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@NamedQuery(name="getalltransfer", query="select t from Transfer t")
public class Transfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String accountTarget;
	
	private String accountOrigin;
	
	private BigDecimal transferValue;
	
	private LocalDate schedulingDate;
	
	private LocalDate transactionDate;
	
	private BigDecimal transferTaxValue;
	
	private double transferTax;

}
