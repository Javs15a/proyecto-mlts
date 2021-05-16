package com.mlts.store.Category.Service;

import com.mlts.store.Category.Dto.CategoriaDto;
import com.mlts.store.Exception.NotFoundException;

import java.util.List;

public interface CategoriaService {
    CategoriaDto findCategoriaById(Integer id) throws NotFoundException;
    List<CategoriaDto> findAllCategorias() throws NotFoundException;
    CategoriaDto createCategoria(CategoriaDto categoriaDto);
    CategoriaDto updateCategoria(CategoriaDto categoriaDto) throws NotFoundException;
    boolean deleteCategoriaById(Integer id) throws NotFoundException;
}
