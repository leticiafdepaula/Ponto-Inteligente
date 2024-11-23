package com.ponto_inteligente.api.repositories;

import com.ponto_inteligente.api.entities.Lancamento;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Transactional(readOnly = true)
@NamedQueries ({
      @NamedQuery (name= "LancamentoRepository.findByFuncionarioId",
        query= "SELECT lanc FROM lancamento lanc WHERE lanc.funcionario.id = :funcionarioid")
})
public interface LancamentoRepository {

    List<Lancamento> findByFuncionarioId(@Param ("funcionarioId")long funcionarioId);
    Page<Lancamento> findByFuncionarioId(@Param ("funcionarioId")long funcionarioId, Pageable pageable); //para paginar os resultados
}
