package br.com.clinical.clinicalApp.repositories;

import br.com.clinical.clinicalApp.models.Paciente;
import br.com.clinical.clinicalApp.models.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}
