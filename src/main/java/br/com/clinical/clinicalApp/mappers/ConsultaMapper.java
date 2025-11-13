package br.com.clinical.clinicalApp.mappers;

import br.com.clinical.clinicalApp.dto.*;
import br.com.clinical.clinicalApp.models.*;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ConsultaMapper {

    @Mapping(target = "paciente", source = "idPaciente", qualifiedByName = "mapPacienteFromId")
    @Mapping(target = "medico", source = "idMedico", qualifiedByName = "mapMedicoFromId")
    Consulta toEntity(RequestConsultaDTO dto);

    @Mapping(target = "paciente", source = "paciente")
    @Mapping(target = "medico", source = "medico")
    ResponseConsultaDTO toResponse(Consulta consulta);


    @Named("mapPacienteFromId")
    default Paciente mapPacienteFromId(Long id) {
        if (id == null) return null;
        Paciente p = new Paciente();
        p.setId(id);
        return p;
    }

    @Named("mapMedicoFromId")
    default Medico mapMedicoFromId(Long id) {
        if (id == null) return null;
        Medico m = new Medico();
        m.setId(id);
        return m;
    }
}
