package com.mlts.store.Category.Controller;

import com.mlts.store.Category.Dto.CategoriaDto;
import com.mlts.store.Category.Service.CategoriaService;
import com.mlts.store.CommonResponse.CommonResponse;
import com.mlts.store.Exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/v1/mlts-store/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public CategoriaDto findCategoriaWithProductsById(
            @RequestParam(value = "id") Integer id
    ) throws NotFoundException {
        return categoriaService.findCategoriaById(id);
    }

    @GetMapping("/all")
    public List<CategoriaDto> findAllCategorias() throws NotFoundException {
        return categoriaService.findAllCategorias();
    }

    @PostMapping
    public CategoriaDto createCategoria(
            @RequestBody CategoriaDto body
    ){
        return categoriaService.createCategoria(body);
    }

    @PutMapping
    public CategoriaDto updateCategoria(
            @RequestBody CategoriaDto body
    ) throws NotFoundException {
        return categoriaService.updateCategoria(body);
    }

    @DeleteMapping
    public CommonResponse deleteCategoria(
            @RequestParam(value = "id") Integer id
    ) throws NotFoundException {
        var response = new CommonResponse("Failed", "Fallo en eliminaci\u00F3n");
        if(categoriaService.deleteCategoriaById(id)) {
            response.setMessage("Eliminado correctamente");
            response.setStatus("Success");
        }
        return response;
    }
}
