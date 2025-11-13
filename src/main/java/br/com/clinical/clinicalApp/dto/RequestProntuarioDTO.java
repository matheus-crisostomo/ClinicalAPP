package br.com.clinical.clinicalApp.dto;


import java.time.LocalDate;

public record RequestProntuarioDTO(
        LocalDate data,
        String diagnostico,
        String tratamento,
        String observacao,
        Long idPaciente,
        Long idMedico
) {}
