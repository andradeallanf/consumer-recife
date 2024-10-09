package com.example.consumer.controller;

import com.example.consumer.dto.PacienteDTO;
import com.example.consumer.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/lista")
    public ResponseEntity<List<PacienteDTO>> geListaPaciente() {
        return ResponseEntity.status(HttpStatus.FOUND).body(pacienteService.getAllPacientes());
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePaciente(
            @RequestBody PacienteDTO pacienteDTO,
            @PathVariable("id") Long id) {
        pacienteService.updatePaciente(pacienteDTO, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePaciente(@PathVariable("id") Long id) {
        pacienteService.deletePaciente(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
