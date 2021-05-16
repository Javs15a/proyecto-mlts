package com.mlts.store.Product.Service.impl;

import com.mlts.store.Entity.Product.ArticuloEntity;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Product.Dao.ArticuloDao;
import com.mlts.store.Product.Dto.ArticuloDto;
import com.mlts.store.Product.Service.ArticuloService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class ArticuloServiceImpl implements  ArticuloService{
    private final ArticuloDao articuloDao;


    @Override
    public ArticuloDto findArticuloById(Integer id) {
        var articuloDb = articuloDao.findById(id);
        if(articuloDb.isPresent()) {
            var articuloObj = new ArticuloDto(
                    articuloDb.get().getId(),
                    articuloDb.get().getCategoriaRef(),
                    articuloDb.get().getCodigo(),
                    articuloDb.get().getNombre(),
                    articuloDb.get().getPrecio(),
                    articuloDb.get().getStock(),
                    articuloDb.get().getDescripcion(),
                    articuloDb.get().getImg(),
                    articuloDb.get().getActivo()
            );
            return articuloObj;
        }
        return null;
    }

    @Override
    public List<ArticuloDto> findArticulosByName(String nombre) throws NotFoundException{
        var listDb = articuloDao.findAllByNombreContainsOrderByNombre(nombre);
        if(listDb.isEmpty()) {
            var errors = new HashMap<String, String>();
            errors.put("error", "No existen articulos");
            errors.put("criteria", nombre);
            throw new NotFoundException("No hay resultados", errors);
        }
        var articulos = new ArrayList<ArticuloDto>();
        listDb.forEach(articuloEntity -> {
            var articulo = new ArticuloDto(
                    articuloEntity.getId(),
                    articuloEntity.getCategoriaRef(),
                    articuloEntity.getCodigo(),
                    articuloEntity.getNombre(),
                    articuloEntity.getPrecio(),
                    articuloEntity.getStock(),
                    articuloEntity.getDescripcion(),
                    articuloEntity.getImg(),
                    articuloEntity.getActivo()
            );
            articulos.add(articulo);
        });
        return articulos;
    }

    @Override
    public ArticuloDto createArticulo(ArticuloDto articuloDto) {
        var articuloEntity = new ArticuloEntity();
        articuloEntity.setNombre(articuloDto.getNombre());
        articuloEntity.setDescripcion(articuloDto.getDescripcion());
        articuloEntity.setCategoriaRef(articuloDto.getCategoria());
        articuloEntity.setCodigo(articuloDto.getCodigo());
        articuloEntity.setPrecio(articuloDto.getPrecioVenta());
        articuloEntity.setImg(articuloDto.getImg());
        articuloEntity.setStock(articuloDto.getStock());
        articuloEntity.setActivo(true);
        return saveAndTransformToDto(articuloEntity);
    }

    @Override
    public ArticuloDto updateArticulo(ArticuloDto articuloDto) throws NotFoundException {
        var articuloDb = articuloDao.findById(articuloDto.getId());
        if(articuloDb.isPresent()){
            var entity = articuloDb.get();
            entity.setNombre(articuloDto.getNombre() == null ? entity.getNombre() : articuloDto.getNombre());
            entity.setDescripcion(articuloDto.getDescripcion() == null ? entity.getDescripcion() : articuloDto.getDescripcion());
            entity.setCodigo(articuloDto.getCodigo() == null ? entity.getCodigo() : articuloDto.getCodigo());
            entity.setStock(articuloDto.getStock() == null ? entity.getStock() : articuloDto.getStock());
            entity.setImg(articuloDto.getImg() == null ? entity.getImg() : articuloDto.getImg());
            entity.setPrecio(articuloDto.getPrecioVenta() == null ? entity.getPrecio() : articuloDto.getPrecioVenta());
            entity.setActivo(articuloDto.getActivo() == null ? entity.getActivo() : articuloDto.getActivo());
            return saveAndTransformToDto(entity);
        }
        var errors = new HashMap<String, String>();
        errors.put("error", "No existe articulo con id: "+ articuloDto.getId());
        throw new NotFoundException("No hay coincidencias", errors);
    }

    @Override
    public boolean deleteArticuloById(Integer id) throws NotFoundException {
        var articuloDb = articuloDao.findById(id);
        if(articuloDb.isPresent()){
            articuloDao.deleteById(id);
            return true;
        }
        var errors = new HashMap<String, String>();
        errors.put("error", "No existe articulo con id: "+ id);
        throw new NotFoundException("No hay coincidencias", errors);
    }

    private ArticuloDto saveAndTransformToDto(ArticuloEntity articuloEntity){
        var articuloDb = articuloDao.save(articuloEntity);
        var articuloDto = new ArticuloDto(
                articuloDb.getId(),
                articuloDb.getCategoriaRef(),
                articuloDb.getCodigo(),
                articuloDb.getNombre(),
                articuloDb.getPrecio(),
                articuloDb.getStock(),
                articuloDb.getDescripcion(),
                articuloDb.getImg(),
                articuloDb.getActivo()
        );
        return articuloDto;
    }
}
