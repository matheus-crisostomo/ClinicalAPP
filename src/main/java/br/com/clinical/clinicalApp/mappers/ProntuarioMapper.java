package br.com.clinical.clinicalApp.mappers;

import br.com.clinical.clinicalApp.dto.*;
import br.com.clinical.clinicalApp.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProntuarioMapper {

    // Mapeia idPaciente -> paciente e idMedico -> medico
    @Mapping(target = "paciente", source = "idPaciente", qualifiedByName = "mapPacienteFromId")
    @Mapping(target = "medico", source = "idMedico", qualifiedByName = "mapMedicoFromId")
    Prontuario toEntity(RequestProntuarioDTO dto);

    ResponseProntuarioDTO toResponse(Prontuario prontuario);

    // Conversão manual de Long -> Paciente
    @Named("mapPacienteFromId")
    default Paciente mapPacienteFromId(Long id) {
        if (id == null) return null;
        Paciente paciente = new Paciente();
        paciente.setId(id);
        return paciente;
    }

    // Conversão manual de Long -> Medico
    @Named("mapMedicoFromId")
    default Medico mapMedicoFromId(Long id) {
        if (id == null) return null;
        Medico medico = new Medico();
        medico.setId(id);
        return medico;
    }
}
