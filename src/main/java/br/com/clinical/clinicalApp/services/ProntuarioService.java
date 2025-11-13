package br.com.clinical.clinicalApp.services;

import br.com.clinical.clinicalApp.dto.RequestProntuarioDTO;
import br.com.clinical.clinicalApp.dto.ResponseProntuarioDTO;
import br.com.clinical.clinicalApp.mappers.ProntuarioMapper;
import br.com.clinical.clinicalApp.repositories.ProntuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProntuarioService {

    private final ProntuarioRepository repository;
    private final ProntuarioMapper mapper;

    @Autowired
    public ProntuarioService(ProntuarioRepository prontuarioRepository,
                             ProntuarioMapper prontuarioMapper) {
        this.repository = prontuarioRepository;
        this.mapper = prontuarioMapper;
    }

    public List<ResponseProntuarioDTO> listarProntuarios() {
        return repository.findAll()
                .stream()
                .map(mapper::mapResponseFromProntuario)
                .toList();
    }

    public ResponseProntuarioDTO getProntuarioById(Long id) {
        return repository.findById(id).map(mapper::mapResponseFromProntuario).orElse(null);
    }

    public ResponseProntuarioDTO criarProntuario(RequestProntuarioDTO dto) {
        var prontuarioSalvo = repository.save(mapper.toEntity(dto));
        return mapper.mapResponseFromProntuario(prontuarioSalvo);
    }

    public void deleteProntuario(Long id) {
        repository.deleteById(id);
    }
}
