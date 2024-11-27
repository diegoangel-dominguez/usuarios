package com.trainibit.usuarios.service;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    //Definir comportamientos que alguien mas va a implementar


    //Lista de Usuarios
    List<UsuarioResponse> findAll();

    //Un solo usuario
    UsuarioResponse findById(UUID uuid);

    //save user
    //Usuario save(Usuario usuario);
    //UsuarioResponse save(Usuario usuario);
    UsuarioResponse save(UsuarioRequest usuarioRequest);
    //metodo update que realice la lógica para actualizar un usuario en la base de datos.
    //Usuario update(Long id, Usuario deletedUser);

    //UsuarioResponse update(Long id, Usuario deletedUser);

    UsuarioResponse update(UUID uuid, UsuarioRequest updatedUser);

    //metodo para manejar la logica de eliminacion. Si el usuario no existe, lanza una excepcion personalizada (como en el caso de la operacion PUT).
    //Usuario delete(Long id);

    UsuarioResponse delete(UUID uuid);

}
