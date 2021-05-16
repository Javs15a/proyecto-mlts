package com.mlts.store.Persona.Dao;

import com.mlts.store.Entity.Transaction.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaDao extends JpaRepository<PersonaEntity, Integer> {
    List<PersonaEntity> findAllByTipoEqualsOrderByNombre(String tipo);
}
