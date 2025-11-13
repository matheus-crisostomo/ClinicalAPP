package br.com.clinical.clinicalApp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(schema = "TB_PRONTUARIOS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private String diagnostico;
    private String tratamento;
    private String observacao;


    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}
