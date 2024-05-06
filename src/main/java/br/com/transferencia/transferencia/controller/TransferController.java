package br.com.transferencia.transferencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transferencia.transferencia.model.request.TransferRequest;
import br.com.transferencia.transferencia.service.TransferService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("v1/transfer")
@Tag(name = "Customer", description = "CRUD de Customer")
public class TransferController {
	
	@Autowired
	private TransferService service;

	@PostMapping(value = "/schedule")
    public Object scheduleTransfer(@RequestBody TransferRequest request) {
		return service.scheduleTransfer(request);
    }
	
	@GetMapping(value = "/transfers")
    public Object getAllTransfers() {
		return service.getAllTransfers();
    }
}
