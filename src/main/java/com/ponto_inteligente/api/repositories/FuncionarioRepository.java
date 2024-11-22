package com.ponto_inteligente.api.repositories;

import com.ponto_inteligente.api.entities.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {

    Funcionarios findByCpf(String cpf);
    Funcionarios findByEmail(String email);
    Funcionarios findByCpfOrEmail(String cpf, String email);
}
