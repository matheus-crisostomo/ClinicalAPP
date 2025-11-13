package br.com.clinical.clinicalApp.repositories;

import br.com.clinical.clinicalApp.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Paciente, Long> {
}
