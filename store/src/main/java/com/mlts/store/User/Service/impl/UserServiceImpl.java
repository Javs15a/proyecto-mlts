package com.mlts.store.User.Service.impl;

import com.mlts.store.Entity.Transaction.TransaccionEntity;
import com.mlts.store.Entity.User.RolEntity;
import com.mlts.store.Entity.User.UsuarioEntity;
import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.Transactions.Dto.TransaccionDto;
import com.mlts.store.User.Dao.UserDao;
import com.mlts.store.User.Dto.RolDto;
import com.mlts.store.User.Dto.UserDto;
import com.mlts.store.User.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public UserDto findUserById(Integer id) throws NotFoundException {
        var userDb = userDao.findById(id);
        if(userDb.isPresent()) {
            var userDto = new UserDto();
            userDto.setId(userDb.get().getId());
            userDto.setRolRef(userDb.get().getRolRef());
            userDto.setUserRol(toRolDto(userDb.get().getRol()));
            userDto.setActivo(userDb.get().getActivo());
            userDto.setEmail(userDb.get().getEmail());
            userDto.setNombre(userDb.get().getNombre());
            userDto.setTelefono(userDb.get().getTelefono());
            userDto.setTransaccionesDirigidas(toListTransaccionDto(userDb.get().getTransacciones()));
            return userDto;
        }
        var errores = new HashMap<String, String>();
        errores.put("err", "No se encuentra usuario con id: "+id);
        throw new NotFoundException("No hay coincidencias", errores);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return null;
    }

    @Override
    public UserDto createUser(UserDto dto) {
        var userEntity = new UsuarioEntity();
        userEntity.setNombre(dto.getNombre());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
        userEntity.setActivo(dto.getActivo());
        userEntity.setRolRef(dto.getRolRef());
        userEntity.setTelefono(dto.getTelefono());
        return saveAndTransformToDto(userEntity);
    }

    @Override
    public UserDto updateUser(UserDto dto) throws NotFoundException {
        var userDb = userDao.findById(dto.getId());
        if(userDb.isPresent()) {
            var userEntity = userDb.get();
            userEntity.setNombre(dto.getNombre() == null ? userEntity.getNombre() : dto.getNombre());
            userEntity.setEmail(dto.getEmail() == null ? userEntity.getEmail() : dto.getEmail());
            userEntity.setPassword(dto.getPassword() == null ? userEntity.getPassword() : dto.getPassword());
            userEntity.setActivo(dto.getActivo() == null ? userEntity.getActivo() : dto.getActivo());
            userEntity.setRolRef(dto.getRolRef() == null ? userEntity.getRolRef() : dto.getRolRef());
            userEntity.setTelefono(dto.getTelefono() == null ? userEntity.getTelefono() : dto.getTelefono());
            return saveAndTransformToDto(userEntity);
        }
        var errores = new HashMap<String, String>();
        errores.put("err", "No se encuentra usuario con id: "+dto.getId());
        throw new NotFoundException("No hay coincidencias", errores);
    }

    @Override
    public boolean deleteUser(Integer id) throws NotFoundException {
        var userDb = userDao.findById(id);
        if(userDb.isPresent()){
            userDao.deleteById(id);
            return true;
        }
        var errores = new HashMap<String, String>();
        errores.put("err", "No se encuentra usuario con id: "+id);
        throw new NotFoundException("No hay coincidencias", errores);
    }

    private RolDto toRolDto(RolEntity rolEntity) {
        return new RolDto(
                rolEntity.getId(),
                rolEntity.getNombre(),
                rolEntity.getDescripcion(),
                rolEntity.getActivo()
        );
    }

    private List<TransaccionDto> toListTransaccionDto(List<TransaccionEntity> transactions){
        var transacciones = new ArrayList<TransaccionDto>();
        transactions.forEach(transaccionEntity -> {
            var transaction = new TransaccionDto();
            transacciones.add(transaction);
        });
        return transacciones;
    }

    private UserDto saveAndTransformToDto(UsuarioEntity usuarioEntity){
        var usuarioDb = userDao.save(usuarioEntity);
        return new UserDto(
                usuarioDb.getId(),
                usuarioDb.getRolRef(),
                toRolDto(usuarioDb.getRol()),
                usuarioDb.getNombre(),
                usuarioDb.getTelefono(),
                usuarioDb.getEmail(),
                usuarioDb.getPassword(),
                usuarioDb.getActivo(),
                toListTransaccionDto(usuarioDb.getTransacciones())
        );
    }
}
