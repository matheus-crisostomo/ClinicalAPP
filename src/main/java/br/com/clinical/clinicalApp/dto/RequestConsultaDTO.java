package br.com.clinical.clinicalApp.dto;

import br.com.clinical.clinicalApp.models.Medico;
import br.com.clinical.clinicalApp.models.StatusConsulta;

import java.time.LocalDateTime;

public record RequestConsultaDTO(Long idPaciente,
                                 Long idMEdico,
                                 LocalDateTime dataConsulta,
                                 Float valorConsulta,
                                 StatusConsulta statusConsulta) {
}
