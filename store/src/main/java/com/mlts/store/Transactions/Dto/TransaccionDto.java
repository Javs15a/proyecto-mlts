package com.mlts.store.Transactions.Dto;

import com.mlts.store.Persona.Dto.PersonaDto;
import com.mlts.store.User.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionDto {
    private Integer id;
    private Integer personaRef;
    private PersonaDto persona;
    private Integer usuarioRef;
    private UserDto usuario;
    private String tipoTransaccion;
    private String serieComprobante;
    private String numeroComprobante;
    private Date fecha;
    private Float impuesto;
    private Float total;
    private DetalleDto detalle;
}
