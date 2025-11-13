package br.com.clinical.clinicalApp.dto;

import br.com.clinical.clinicalApp.models.StatusConsulta;
import java.time.LocalDateTime;

public record UpdateConsultaDTO(LocalDateTime dataConsulta,
                                Float valorConsulta,
                                StatusConsulta statusConsulta) {
}
