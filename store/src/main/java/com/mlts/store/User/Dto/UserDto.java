package com.mlts.store.User.Dto;

import com.mlts.store.Transactions.Dto.TransaccionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private Integer rolRef;
    private RolDto userRol;
    private String nombre;
    private String telefono;
    private String email;
    private String password;
    private Boolean activo;
    private List<TransaccionDto> transaccionesDirigidas;
}
