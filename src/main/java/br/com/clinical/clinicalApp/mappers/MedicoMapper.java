package br.com.clinical.clinicalApp.mappers;


import br.com.clinical.clinicalApp.dto.RequestMedicoDTO;
import br.com.clinical.clinicalApp.dto.ResponseMedicoDTO;
import br.com.clinical.clinicalApp.models.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MedicoMapper {
    ResponseMedicoDTO mapResponseFromMedico(Medico medico);
    Medico toMedico(RequestMedicoDTO dto);
}
