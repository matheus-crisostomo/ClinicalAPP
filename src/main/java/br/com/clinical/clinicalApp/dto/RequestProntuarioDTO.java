package br.com.clinical.clinicalApp.dto;

import br.com.clinical.clinicalApp.models.Medico;
import br.com.clinical.clinicalApp.models.Paciente;

import java.time.LocalDateTime;

public record RequestProntuarioDTO(
        LocalDateTime data,
        String diagnostico,
        String tratamento,
        String observacao,
        Long idPaciente,
        Long idMedico
) {}
