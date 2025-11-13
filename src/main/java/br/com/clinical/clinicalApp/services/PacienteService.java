package br.com.clinical.clinicalApp.services;

import br.com.clinical.clinicalApp.dto.ResponsePacienteDTO;
import br.com.clinical.clinicalApp.mappers.PacienteMapper;
import br.com.clinical.clinicalApp.models.Paciente;
import br.com.clinical.clinicalApp.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteService {
    private PacienteRepository repository;
    private PacienteMapper mapper;

    public List<ResponsePacienteDTO> listarPacientes() {
        return repository.findAll().stream()
                .map(mapper::mapResponseFromPaciente).toList();
    }

}
