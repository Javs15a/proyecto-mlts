package com.mlts.store.Persona.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    private Integer id;
    private String tipoPersona;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
}
