package com.mlts.store.Product.Service;


import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Product.Dto.ArticuloDto;

import java.util.List;

public interface ArticuloService {
    ArticuloDto findArticuloById(Integer id);
    List<ArticuloDto> findArticulosByName(String nombre) throws NotFoundException;
    ArticuloDto createArticulo(ArticuloDto articuloDto);
    ArticuloDto updateArticulo(ArticuloDto articuloDto) throws NotFoundException;
    boolean deleteArticuloById(Integer id) throws NotFoundException;
}
