package br.com.clinical.clinicalApp.services;

import br.com.clinical.clinicalApp.dto.RequestPacienteDTO;
import br.com.clinical.clinicalApp.dto.ResponsePacienteDTO;
import br.com.clinical.clinicalApp.mappers.PacienteMapper;
import br.com.clinical.clinicalApp.models.Paciente;
import br.com.clinical.clinicalApp.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteService {
    private PacienteRepository repository;
    private PacienteMapper mapper;

    public List<ResponsePacienteDTO> listarPacientes() {
        return repository.findAll()
                .stream()
                .map(mapper::mapResponseFromPaciente)
                .toList();
    }

    public ResponsePacienteDTO getPacienteByID(@PathVariable Long id) {
        return repository.findById(id).map(mapper::mapResponseFromPaciente).orElse(null);
    }

    public ResponsePacienteDTO salvarPaciente(RequestPacienteDTO paciente) {
        var pacienteSalvo = repository.save(mapper.toPaciente(paciente));
        return mapper.mapResponseFromPaciente(pacienteSalvo);
    }

    public void deletarPaciente(Long id) {
        repository.deleteById(id);
    }

}
