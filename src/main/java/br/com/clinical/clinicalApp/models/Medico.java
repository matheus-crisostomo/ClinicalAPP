package br.com.clinical.clinicalApp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_MEDICOS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public  class Medico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String crm;
}

