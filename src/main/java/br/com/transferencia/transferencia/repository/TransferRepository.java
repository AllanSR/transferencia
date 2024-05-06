package br.com.transferencia.transferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transferencia.transferencia.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{

}
