package br.com.clinical.clinicalApp.repositories;

import br.com.clinical.clinicalApp.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {}
