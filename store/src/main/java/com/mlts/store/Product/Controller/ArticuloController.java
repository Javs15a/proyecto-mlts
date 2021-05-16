package com.mlts.store.Product.Controller;

import com.mlts.store.CommonResponse.CommonResponse;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Product.Dto.ArticuloDto;
import com.mlts.store.Product.Service.ArticuloService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/v1/mlts-store/articulos")
public class ArticuloController {
    private final ArticuloService articuloService;

    @GetMapping
    public ArticuloDto findArticuloById(
            @RequestParam(value = "id") Integer id
    ) {
        return articuloService.findArticuloById(id);
    }

    @GetMapping("/filter")
    public List<ArticuloDto> findArticulosByName(
            @RequestParam(value = "nombre") String nombre
    ) throws NotFoundException{
        return articuloService.findArticulosByName(nombre);
    }

    @PostMapping
    public ArticuloDto newArticulo(
            @RequestBody ArticuloDto body
    ) {
        return articuloService.createArticulo(body);
    }

    @PutMapping
    public ArticuloDto updateArticulo(
            @RequestBody ArticuloDto body
    ) throws NotFoundException {
        return articuloService.updateArticulo(body);
    }

    @DeleteMapping
    public CommonResponse deleteArticulo(
            @RequestParam(value = "id") Integer id
    ) throws NotFoundException {
        var response = new CommonResponse("Failed", "Fallo en eliminaci\u00F3n de art\u00EDculo");
        if(articuloService.deleteArticuloById(id)) {
            response.setStatus("Success");
            response.setMessage("Art\u00EDculo eliminado");
        }
        return response;
    }
}
