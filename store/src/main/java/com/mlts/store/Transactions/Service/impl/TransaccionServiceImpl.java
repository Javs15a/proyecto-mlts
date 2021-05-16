package com.mlts.store.Transactions.Service.impl;

import com.mlts.store.Entity.Transaction.TransaccionEntity;
import com.mlts.store.Transactions.Dao.TransaccionDao;
import com.mlts.store.Transactions.Dto.TransaccionDto;
import com.mlts.store.Transactions.Service.TransaccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransaccionServiceImpl implements TransaccionService {
    private final TransaccionDao transaccionDao;
    @Override
    public TransaccionDto findTransaccionById(Integer id) {
        return null;
    }

    @Override
    public List<TransaccionDto> findAllTransacciones() {
        return null;
    }

    @Override
    public TransaccionDto createTransaccion(TransaccionDto dto) {
        return null;
    }

    @Override
    public TransaccionDto updateTransaccion(TransaccionDto dto) {
        return null;
    }

    @Override
    public boolean deleteTransaccion(Integer id) {
        return true;
    }

    private TransaccionDto saveAndTransformToDto(TransaccionEntity transaccionEntity){
        return null;
    }
}
