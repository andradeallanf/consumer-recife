package com.example.consumer.message;

import com.example.consumer.dto.PacienteDTO;
import com.example.consumer.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PacienteService pacienteService;

    @KafkaListener(topics = "paciente-topic", groupId = "store-posts-group")
    public void listening(PacienteDTO pacienteDTO) {
        LOG.info("Recebeu informacao do paciente: {}", pacienteDTO);
        pacienteService.newPaciente(pacienteDTO);
    }
}
