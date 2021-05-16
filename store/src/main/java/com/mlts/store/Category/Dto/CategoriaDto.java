package com.mlts.store.Category.Dto;

import com.mlts.store.Product.Dto.ArticuloDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    private List<ArticuloDto> articulos;
}
