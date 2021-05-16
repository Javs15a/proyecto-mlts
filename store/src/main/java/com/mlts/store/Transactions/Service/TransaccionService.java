package com.mlts.store.Transactions.Service;

import com.mlts.store.Transactions.Dto.TransaccionDto;

import java.util.List;

public interface TransaccionService {
    TransaccionDto findTransaccionById(Integer id);
    List<TransaccionDto> findAllTransacciones();
    TransaccionDto createTransaccion(TransaccionDto dto);
    TransaccionDto updateTransaccion(TransaccionDto dto);
    boolean deleteTransaccion(Integer id);
}
