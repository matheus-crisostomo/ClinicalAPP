package br.com.clinical.clinicalApp.services;


import br.com.clinical.clinicalApp.dto.RequestConsultaDTO;
import br.com.clinical.clinicalApp.dto.ResponseConsultaDTO;
import br.com.clinical.clinicalApp.dto.UpdateConsultaDTO;
import br.com.clinical.clinicalApp.mappers.ConsultaMapper;
import br.com.clinical.clinicalApp.models.Consulta;
import br.com.clinical.clinicalApp.repositories.ConsultaRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultaService {
    private ConsultaRepository repository;
    private ConsultaMapper mapper;

    public List<ResponseConsultaDTO> listarConsultas() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse).toList();
    }

    public ResponseConsultaDTO getConsultabyId(Long id) {
        return repository.findById(id).map(mapper::toResponse).orElse(null);
    }

    public ResponseConsultaDTO cadastrarConsulta(RequestConsultaDTO consulta) {
        var consultaSalva = repository.save(mapper.toEntity(consulta));
        return mapper.toResponse(consultaSalva);
    }

    public void removerConsulta(Long id) {
        repository.deleteById(id);
    }

    public ResponseConsultaDTO atualizarConsulta(Long id, UpdateConsultaDTO dto) {
        Consulta consulta = repository.findById(id).orElseThrow(()-> new RuntimeException("Consulta não encontrada com ID: "+id));
        if (dto.dataConsulta() != null) {
            consulta.setDataConsulta(dto.dataConsulta());
        }
        if (dto.valorConsulta() != null) {
            consulta.setValorConsulta(dto.valorConsulta());
        }
        if (dto.statusConsulta() != null) {
            consulta.setStatusConsulta(dto.statusConsulta());
        }

        Consulta atualizado = repository.save(consulta);
        return mapper.toResponse(atualizado);
    }
}
