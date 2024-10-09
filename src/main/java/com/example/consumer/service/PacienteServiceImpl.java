package com.example.consumer.service;

import com.example.consumer.dto.PacienteDTO;
import com.example.consumer.entity.PacienteEntity;
import com.example.consumer.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    public List<PacienteDTO> getAllPacientes() {
        List<PacienteDTO> listaPaciente = new ArrayList<>();
        pacienteRepository.findAll().forEach(item -> {
            listaPaciente.add(mapPacienteEntityToDTO(item));
        });
        return listaPaciente;
    }

    @Override
    public void newPaciente(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity =  pacienteDTO.toEntity();
        pacienteRepository.save(pacienteEntity);
    }

    @Override
    public void updatePaciente(PacienteDTO pacienteDTO, Long cdPaciente) {
        pacienteRepository.findById(cdPaciente).ifPresentOrElse(item -> {
            item.setNmPaciente(pacienteDTO.getNmPaciente());
            item.setCdPaciente(pacienteDTO.getCdPaciente());
            item.setDtNascimento(parseStringToDate(pacienteDTO.getDtNascimento()));
            pacienteRepository.save(item);
        }, ()-> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void deletePaciente(Long cdPaciente) {
        pacienteRepository.deleteById(cdPaciente);
    }

    private PacienteDTO mapPacienteEntityToDTO(PacienteEntity pacienteEntity) {
        return PacienteDTO.builder()
                .cdPaciente(pacienteEntity.getCdPaciente())
                .nmPaciente(pacienteEntity.getNmPaciente())
                .cpfPaciente(pacienteEntity.getCpfPaciente())
                .dtNascimento(parseDataToString(pacienteEntity.getDtNascimento()))
                .build();
    }

    private Date parseStringToDate (String data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dataNascimento = df.parse(data);
            return dataNascimento;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String parseDataToString(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }
}
