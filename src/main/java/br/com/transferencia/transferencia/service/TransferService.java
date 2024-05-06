package br.com.transferencia.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import br.com.transferencia.transferencia.model.Transfer;
import br.com.transferencia.transferencia.model.request.TransferRequest;

@Service
public class TransferService {
	
	private static final BigDecimal NO_TAXES_FEE = BigDecimal.valueOf(0);
	
	
	public Transfer scheduleTransfer(TransferRequest request) {
		
		validadeRequest(request);
		
		Transfer transfer = new Transfer();
		transfer.setAccountOrigin(request.getAccountOrigin());
		transfer.setAccountTarget(request.getAccountTarget());
		transfer.setSchedulingDate(request.getSchedulingDate());
		transfer.setTransactionDate(LocalDate.now());
		calculateTaxes(request, transfer);
		
		return transfer;
	}

	
	private void calculateTaxes(TransferRequest request, Transfer transfer){
		
		long diff = ChronoUnit.DAYS.between(request.getSchedulingDate(), LocalDate.now());

		if(diff == 0) {
			transfer.setTransferTax(Double.valueOf(2.5));
			transfer.setTransferTaxValue(new BigDecimal(3.00));
		} else if(diff > 1 && diff <= 10) {
			transfer.setTransferTax(Double.valueOf(0.0));
			transfer.setTransferTaxValue(new BigDecimal(12.00));
		} else if(diff >= 11 && diff <= 20 ) {
			transfer.setTransferTax(Double.valueOf(8.2));
			transfer.setTransferTaxValue(NO_TAXES_FEE);
		} else if(diff >= 21 && diff <= 30 ) {
			transfer.setTransferTax(Double.valueOf(6.9));
			transfer.setTransferTaxValue(NO_TAXES_FEE);
		} else if(diff >= 31 && diff <= 40 ) {
			transfer.setTransferTax(Double.valueOf(4.7));
			transfer.setTransferTaxValue(NO_TAXES_FEE);
		} else if(diff >= 41 && diff <= 50 ) {
			transfer.setTransferTax(Double.valueOf(1.7));
			transfer.setTransferTaxValue(NO_TAXES_FEE);
		} else {
			throw new RuntimeException("Valores de agendamento indisponiveis");
		}
	}
	
	private void validadeRequest(TransferRequest request) {
		
		if(null == request)
			throw new RuntimeException("Request nulo!");
		
		if (null == request.getAccountOrigin() || request.getAccountOrigin().length() != 10)
			throw new RuntimeException("Valor invalido da conta origem!");
		
		if (null == request.getAccountTarget() || request.getAccountTarget().length() != 10)
			throw new RuntimeException("Valor invalido da conta origem!");
		
		if (null == request.getSchedulingDate() || ChronoUnit.DAYS.between(request.getSchedulingDate(), LocalDate.now()) < 0 )
			throw new RuntimeException("Valor invalido da data programada de transferencia!");
		
		if (null == request.getTransferValue() || request.getTransferValue().compareTo(BigDecimal.ZERO) < 0)
			throw new RuntimeException("Valor invalido do valor de transferencia!");
	}
}
