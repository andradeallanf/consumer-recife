package com.example.consumer.service;

import com.example.consumer.dto.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacienteService {

    List<PacienteDTO> getAllPacientes();

    void newPaciente(PacienteDTO pacienteDTO);

    void updatePaciente(PacienteDTO pacienteDTO, Long cdPaciente);

    void deletePaciente(Long cdPaciente);

}
