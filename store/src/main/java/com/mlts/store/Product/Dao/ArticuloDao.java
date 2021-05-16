package com.mlts.store.Product.Dao;

import com.mlts.store.Entity.Product.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloDao extends JpaRepository<ArticuloEntity, Integer> {
    List<ArticuloEntity> findAllByNombreContainsOrderByNombre(String nombre);
}
