package com.mlts.store.Transactions.Controller;

import com.mlts.store.CommonResponse.CommonResponse;
import com.mlts.store.Transactions.Dto.TransaccionDto;
import com.mlts.store.Transactions.Service.TransaccionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/v1/mlts-store/transacciones")
public class TransaccionController {
    private final TransaccionService transaccionService;

    @GetMapping
    public TransaccionDto findTransaccionById(
            @RequestParam(value = "id") Integer id
    ){
        return transaccionService.findTransaccionById(id);
    }

    @GetMapping("/all")
    public List<TransaccionDto> findAllTransacciones(){
        return  transaccionService.findAllTransacciones();
    }

    @PostMapping
    public TransaccionDto createTransaccion(
            @RequestBody TransaccionDto body
    ){
        return transaccionService.createTransaccion(body);
    }

    @PutMapping
    public TransaccionDto updateTransaccion(
            @RequestBody TransaccionDto body
    ){
        return transaccionService.updateTransaccion(body);
    }

    @DeleteMapping
    public CommonResponse deleteTransaccion(
            @RequestParam(value = "id") Integer id
    ){
        var response = new CommonResponse("Failed", "Fallo al eliminar");
        if(transaccionService.deleteTransaccion(id)){
            response.setStatus("Succes");
            response.setMessage("Transacci\u00F3n eliminada correctamente");
        }
        return response;
    }
}
