package br.com.clinical.clinicalApp.services;


import br.com.clinical.clinicalApp.dto.RequestMedicoDTO;
import br.com.clinical.clinicalApp.dto.ResponseMedicoDTO;
import br.com.clinical.clinicalApp.models.Medico;
import br.com.clinical.clinicalApp.repositories.MedicoRepository;
import lombok.AllArgsConstructor;
import br.com.clinical.clinicalApp.mappers.MedicoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicoService {
    private final MedicoRepository repository;
    private final MedicoMapper mapper;

    public List<ResponseMedicoDTO> listaMedicos() {
        return repository.findAll().stream()
                .map(mapper::mapResponseFromMedico)
                .toList();
    }

    public ResponseMedicoDTO getMedicoById(Long id) {
        return repository.findById(id).map(mapper::mapResponseFromMedico).orElse(null);
    }

    public ResponseMedicoDTO cadastrarMedico(RequestMedicoDTO medico){
        var medicoSalvo = repository.save(mapper.toMedico(medico));
        return mapper.mapResponseFromMedico(medicoSalvo);
    }

    public void deletarMedico(Long id) {
        repository.deleteById(id);
    }

}
