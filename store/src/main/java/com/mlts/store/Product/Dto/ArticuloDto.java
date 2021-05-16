package com.mlts.store.Product.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloDto implements Serializable {
    private Integer id;
    private Integer categoria;
    private String codigo;
    private String nombre;
    private Float precioVenta;
    private Integer stock;
    private String descripcion;
    private String img;
    private Boolean activo;
}
