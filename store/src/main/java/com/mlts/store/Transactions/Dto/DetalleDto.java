package com.mlts.store.Transactions.Dto;

import com.mlts.store.Product.Dto.ArticuloDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleDto {
    private Integer id;
    private Integer transactionRef;
    private Integer articuloRef;
    private ArticuloDto articulo;
    private Integer cantidad;
    private Float montoCalc;
    private Float descuento;
}
