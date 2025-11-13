package br.com.clinical.clinicalApp.dto;

import java.time.LocalDateTime;

public record ResponseProntuarioDTO(
        Long id,
        LocalDateTime data,
        String diagnostico,
        String tratamento,
        String observacao,
        ResponsePacienteDTO paciente,
        ResponseMedicoDTO medico
) {}