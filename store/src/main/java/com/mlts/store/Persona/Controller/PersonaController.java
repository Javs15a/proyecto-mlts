package com.mlts.store.Persona.Controller;

import com.mlts.store.Exception.BadRequestException;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Persona.Dto.PersonaDto;
import com.mlts.store.Persona.Service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/v1/mlts-store/personas/")
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping
    public PersonaDto findPersonaById(
            @RequestParam(value = "id") Integer id
    ){
        return personaService.findPersonaById(id);
    }

    @GetMapping("/filter")
    public List<PersonaDto> findPersonaByTipo(
            @RequestParam(value = "tipo") String tipo
    ) throws BadRequestException, NotFoundException {
        return personaService.findAllPersonasByTipo(tipo);
    }

    @PostMapping
    public PersonaDto createPersona(
            @RequestBody PersonaDto body
    ) throws BadRequestException {
        return personaService.createPersona(body);
    }

    @PutMapping
    public PersonaDto updatePersona(
            @RequestBody PersonaDto body
    ){
        return personaService.updatePersona(body);
    }

    @DeleteMapping
    public void deletePersona(
            @RequestParam(value = "id") Integer id
    ){
        personaService.deletePersonaById(id);
    }
}
