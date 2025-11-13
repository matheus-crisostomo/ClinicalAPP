package br.com.clinical.clinicalApp.dto;

import br.com.clinical.clinicalApp.models.Consulta;
import br.com.clinical.clinicalApp.models.Medico;
import br.com.clinical.clinicalApp.models.Paciente;
import br.com.clinical.clinicalApp.models.StatusConsulta;

import java.time.LocalDateTime;

public record ResponseConsultaDTO(Long id, Paciente paciente,
                                  Medico medico,
                                  LocalDateTime dataConsulta,
                                  Float valorConsulta,
                                  StatusConsulta statusConsulta) {
}
