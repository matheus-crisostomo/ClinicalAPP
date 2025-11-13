package br.com.clinical.clinicalApp.mappers;

import br.com.clinical.clinicalApp.dto.RequestPacienteDTO;
import br.com.clinical.clinicalApp.dto.ResponsePacienteDTO;
import br.com.clinical.clinicalApp.models.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PacienteMapper {
    ResponsePacienteDTO mapResponseFromPaciente(Paciente paciente);
    Paciente toPaciente(RequestPacienteDTO dto);
}
