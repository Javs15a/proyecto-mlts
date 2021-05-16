package com.mlts.store.Category.Dao;

import com.mlts.store.Entity.Product.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaDao extends JpaRepository<CategoriaEntity, Integer> {

}
