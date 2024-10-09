package com.example.consumer.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="PACIENTE")
@Data
@NoArgsConstructor
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CD_PACIENTE")
    private Long cdPaciente;

    @Column(name = "NM_PACIENTE")
    private String nmPaciente;

    @Column(name = "CPF")
    private  String cpfPaciente;

    @Column(name = "DATA_NASCIMENTO")
    private Date dtNascimento;

}
