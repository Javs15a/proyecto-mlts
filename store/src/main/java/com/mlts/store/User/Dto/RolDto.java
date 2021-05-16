package com.mlts.store.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean activo;
}
