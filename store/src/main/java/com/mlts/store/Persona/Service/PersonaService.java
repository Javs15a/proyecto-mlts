package com.mlts.store.Persona.Service;

import com.mlts.store.Exception.BadRequestException;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Persona.Dto.PersonaDto;

import java.util.List;

public interface PersonaService {
    PersonaDto findPersonaById(Integer id);
    List<PersonaDto> findAllPersonasByTipo(String tipo) throws BadRequestException, NotFoundException;
    PersonaDto createPersona(PersonaDto dto) throws BadRequestException;
    PersonaDto updatePersona(PersonaDto dto);
    void deletePersonaById(Integer id);
}
