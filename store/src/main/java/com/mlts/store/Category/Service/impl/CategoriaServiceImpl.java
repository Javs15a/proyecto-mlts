package com.mlts.store.Category.Service.impl;

import com.mlts.store.Category.Dao.CategoriaDao;
import com.mlts.store.Category.Dto.CategoriaDto;
import com.mlts.store.Category.Service.CategoriaService;
import com.mlts.store.Entity.Product.ArticuloEntity;
import com.mlts.store.Entity.Product.CategoriaEntity;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Product.Dto.ArticuloDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaDao categoriaDao;

    @Override
    public CategoriaDto findCategoriaById(Integer id) throws NotFoundException {
        var categoriaDb = categoriaDao.findById(id);
        if(categoriaDb.isPresent()) {
            var categoriaWithProducts = new CategoriaDto();
            categoriaWithProducts.setId(categoriaDb.get().getId());
            categoriaWithProducts.setNombre(categoriaDb.get().getNombre());
            categoriaWithProducts.setDescripcion(categoriaDb.get().getDescripcion());
            categoriaWithProducts.setActivo(categoriaDb.get().getActivo());

            var articulosDb = categoriaDb.get().getArticulos();
            List<ArticuloDto> articuloDtoList = toListDto(articulosDb);

            categoriaWithProducts.setArticulos(articuloDtoList);
            return categoriaWithProducts;
        }
        var errores = new HashMap<String, String>();
        errores.put("err", "No se encontr\u00F3 en base de datos una categor\u00EDa con id: " + id);
        throw new NotFoundException("No hay coincidencias", errores);
    }

    @Override
    public List<CategoriaDto> findAllCategorias() throws NotFoundException {
        var categoriasDb = categoriaDao.findAll();
        if(categoriasDb.isEmpty()) {
            var errores = new HashMap<String, String>();
            errores.put("err", "No se encontraron categor\u00EDas en base de datos");
            throw new NotFoundException("No hay coincidencias", errores);
        }
        List<CategoriaDto> categoriaList = new ArrayList<>();
        categoriasDb.forEach(catEntity -> {
            var categoriaDto = new CategoriaDto();
            categoriaDto.setId(catEntity.getId());
            categoriaDto.setNombre(catEntity.getNombre());
            categoriaDto.setDescripcion(catEntity.getDescripcion());
            categoriaDto.setActivo(catEntity.getActivo());

            var articulosDb = catEntity.getArticulos();
            List<ArticuloDto> articuloDtoList = toListDto(articulosDb);
            categoriaDto.setArticulos(articuloDtoList);

            categoriaList.add(categoriaDto);
        });
        return categoriaList;
    }

    @Override
    public CategoriaDto createCategoria(CategoriaDto categoriaDto) {
        var categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre(categoriaDto.getNombre());
        categoriaEntity.setDescripcion(categoriaDto.getDescripcion());
        categoriaEntity.setActivo(categoriaDto.getActivo());
        return saveAndTransformToDto(categoriaEntity);
    }

    @Override
    public CategoriaDto updateCategoria(CategoriaDto categoriaDto) throws NotFoundException {
        var categoriaEntity = categoriaDao.findById(categoriaDto.getId());
        if(categoriaEntity.isPresent()){
            var entity = categoriaEntity.get();
            entity.setNombre(categoriaDto.getNombre() == null ? entity.getNombre() : categoriaDto.getNombre());
            entity.setDescripcion(categoriaDto.getDescripcion() == null ? entity.getDescripcion() : categoriaDto.getDescripcion());
            entity.setActivo(categoriaDto.getActivo() == null ? entity.getActivo() : categoriaDto.getActivo());
            return saveAndTransformToDto(entity);
        }
        var errores = new HashMap<String, String>();
        errores.put("err", "No se encuentra la categoria con id: " + categoriaDto.getId());
        throw new NotFoundException("No hay coincidencias", errores);
    }

    @Override
    public boolean deleteCategoriaById(Integer id) throws NotFoundException{
        var categoriaEntity = categoriaDao.findById(id);
        if(categoriaEntity.isPresent()) {
            categoriaDao.deleteById(id);
            return true;
        }
        var errores = new HashMap<String, String>();
        errores.put("err", "No se encuentra la categoria con id: " + id);
        throw new NotFoundException("No hay coincidencias", errores);
    }

    private CategoriaDto saveAndTransformToDto(CategoriaEntity categoriaEntity){
        var categoriaDb = categoriaDao.save(categoriaEntity);
        var categoriaDto = new CategoriaDto(
            categoriaDb.getId(),
            categoriaDb.getNombre(),
            categoriaDb.getDescripcion(),
            categoriaDb.getActivo(),
                toListDto(categoriaDb.getArticulos())
        );
        return categoriaDto;
    }

    private List<ArticuloDto> toListDto(List<ArticuloEntity> articulos){
        List<ArticuloDto> articuloDtoList = new ArrayList<>();

        articulos.forEach(articuloEntity -> {
            var articuloDto = new ArticuloDto();
            articuloDto.setId(articuloEntity.getId());
            articuloDto.setCategoria(articuloEntity.getCategoriaRef());
            articuloDto.setNombre(articuloEntity.getNombre());
            articuloDto.setDescripcion(articuloEntity.getDescripcion());
            articuloDto.setCodigo(articuloEntity.getCodigo());
            articuloDto.setStock(articuloEntity.getStock());
            articuloDto.setPrecioVenta(articuloEntity.getPrecio());
            articuloDto.setImg(articuloEntity.getImg());
            articuloDto.setActivo(articuloEntity.getActivo());

            articuloDtoList.add(articuloDto);
        });
        return articuloDtoList;
    }
}
