package com.mlts.store.Persona.Service.impl;

import com.mlts.store.Entity.Transaction.PersonaEntity;
import com.mlts.store.Exception.BadRequestException;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Persona.Dao.PersonaDao;
import com.mlts.store.Persona.Dto.PersonaDto;
import com.mlts.store.Persona.Service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDao personaDao;
    private final String TYPE_CLIENT = "cliente";
    private final String TYPE_SUPPLIER = "proveedor";

    @Override
    public PersonaDto findPersonaById(Integer id) {

        return null;
    }

    @Override
    public List<PersonaDto> findAllPersonasByTipo(String tipo) throws BadRequestException, NotFoundException {
        var errors = new HashMap<String, String>();
        if(tipo.equalsIgnoreCase(TYPE_CLIENT) || tipo.equalsIgnoreCase(TYPE_SUPPLIER)){
            var personasDb = personaDao.findAllByTipoEqualsOrderByNombre(tipo);
            if(personasDb.isEmpty()){
                errors.put("err", "No se encontraron personas de tipo " + tipo);
                throw new NotFoundException("No hay coincidencias", errors);
            }
            var listPersonas = new ArrayList<PersonaDto>();
            personasDb.forEach(personaEntity -> {
                listPersonas.add(new PersonaDto(
                        personaEntity.getId(),
                        personaEntity.getTipo(),
                        personaEntity.getNombre(),
                        personaEntity.getDireccion(),
                        personaEntity.getTelefono(),
                        personaEntity.getEmail()
                ));
            });
            return listPersonas;
        }
        errors.put("err", "El tipo persona " + tipo + " es incorrecto");
        errors.put("criteria", "Debe ser cliente o proveedor");
        throw new BadRequestException("Error al buscar", errors);
    }

    @Override
    public PersonaDto createPersona(PersonaDto dto) throws BadRequestException {
        if(dto.getTipoPersona().equalsIgnoreCase(TYPE_CLIENT) || dto.getTipoPersona().equalsIgnoreCase(TYPE_SUPPLIER)){
            var personaEntity = new PersonaEntity();
            personaEntity.setId(dto.getId());
            personaEntity.setDireccion(dto.getDireccion());
            personaEntity.setEmail(dto.getEmail());
            personaEntity.setNombre(dto.getNombre());
            personaEntity.setTelefono(dto.getTelefono());
            personaEntity.setTipo(dto.getTipoPersona().toLowerCase());
            return saveAndTransformToDto(personaEntity);
        }
        var errors = new HashMap<String, String>();
        errors.put("err", "El tipo persona " + dto.getTipoPersona() + " es incorrecto");
        errors.put("criteria", "Debe ser cliente o proveedor");
        throw new BadRequestException("Error al insertar", errors);
    }

    @Override
    public PersonaDto updatePersona(PersonaDto dto) {
        return null;
    }

    @Override
    public void deletePersonaById(Integer id) {

    }

    private PersonaDto saveAndTransformToDto(PersonaEntity personaEntity){
        var personaDb = personaDao.save(personaEntity);
        return new PersonaDto(
                personaDb.getId(),
                personaDb.getTipo(),
                personaDb.getNombre(),
                personaDb.getDireccion(),
                personaDb.getTelefono(),
                personaDb.getEmail()
        );
    }
}
