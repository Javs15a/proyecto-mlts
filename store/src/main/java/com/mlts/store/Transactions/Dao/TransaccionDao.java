package com.mlts.store.Transactions.Dao;

import com.mlts.store.Entity.Transaction.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransaccionDao extends JpaRepository<TransaccionEntity, Integer> {
    List<TransaccionEntity> findAllByTipoTransaccionEqualsOrderByFecha(String tipoTransaccion);
    List<TransaccionEntity> findAllByFechaBetween(Date fechaInicio, Date fechaFinal);
    List<TransaccionEntity> findAllBySerieComprobanteOrderByNumeroComprobante(String serieC);
}
