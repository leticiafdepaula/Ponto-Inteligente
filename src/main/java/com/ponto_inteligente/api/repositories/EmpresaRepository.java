package com.ponto_inteligente.api.repositories;

import com.ponto_inteligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Transactional(readOnly = true)
    Empresa findByCnpj(String cnpj);
}
