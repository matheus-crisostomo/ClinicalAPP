package br.com.clinical.clinicalApp.dto;

import java.time.LocalDate;

public record ResponsePacienteDTO(Long id, String nome, String cpf, String telefone, String email, String endereco,
                                  LocalDate dataNascimento) {
}
