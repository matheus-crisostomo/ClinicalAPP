package br.com.clinical.clinicalApp.dto;

import java.time.LocalDate;

public record RequestPacienteDTO (String nome, String cpf, String telefone, String email, String endereco,
                                 LocalDate dataNascimento){
}
