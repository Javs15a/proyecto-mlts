package com.mlts.store.Transactions.Dao;

import com.mlts.store.Entity.Transaction.DetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleDao extends JpaRepository<DetalleEntity, Integer> {
}
