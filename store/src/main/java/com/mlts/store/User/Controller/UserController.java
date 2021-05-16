package com.mlts.store.User.Controller;

import com.mlts.store.CommonResponse.CommonResponse;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.User.Dto.UserDto;
import com.mlts.store.User.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/v1/mlts-store/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public UserDto findUserById(
            @RequestParam(value = "id") Integer id
    ) throws NotFoundException {
        return userService.findUserById(id);
    }

    @PostMapping
    public UserDto createUser(
            @RequestBody UserDto body
    ){
        return userService.createUser(body);
    }

    @PutMapping
    public UserDto updateUser(
            @RequestBody UserDto body
    ) throws NotFoundException {
        return userService.updateUser(body);
    }

    @DeleteMapping
    public CommonResponse deleteUser(
            @RequestParam(value = "id") Integer id
    )throws NotFoundException{
        var response = new CommonResponse("Failed", "Fallo al eliminar usuario");
        if(userService.deleteUser(id)){
            response.setMessage("Se elimin\u00F3 correctamente el usuario");
            response.setStatus("Success");
        }
        return response;
    }
}
