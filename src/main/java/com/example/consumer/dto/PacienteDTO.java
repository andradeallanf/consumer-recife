package com.example.consumer.dto;

import com.example.consumer.entity.PacienteEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude
public class PacienteDTO {

    private Long cdPaciente;

    private String nmPaciente;

    private String cpfPaciente;

    private String dtNascimento;

    public PacienteEntity toEntity() {
        PacienteEntity paciente = new PacienteEntity();
        paciente.setCdPaciente(this.cdPaciente);
        paciente.setNmPaciente(this.nmPaciente);
        paciente.setCpfPaciente(this.cpfPaciente);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dtNascimento = dateFormat.parse(this.dtNascimento);
            paciente.setDtNascimento(dtNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return paciente;
    }


}