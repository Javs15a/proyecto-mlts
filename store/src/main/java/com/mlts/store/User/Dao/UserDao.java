package com.mlts.store.User.Dao;

import com.mlts.store.Entity.User.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UsuarioEntity, Integer> {
}
