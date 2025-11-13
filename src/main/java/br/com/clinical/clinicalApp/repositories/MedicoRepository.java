package br.com.clinical.clinicalApp.repositories;

import br.com.clinical.clinicalApp.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
