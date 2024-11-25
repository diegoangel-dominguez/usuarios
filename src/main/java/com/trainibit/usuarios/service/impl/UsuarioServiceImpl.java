package com.trainibit.usuarios.service.impl;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.mapper.UsuarioMapper;
import com.trainibit.usuarios.repository.UsuarioRepository;
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;
import com.trainibit.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


//Este estereotipo siempre va en la implementacion de la interface

@Service
public class UsuarioServiceImpl implements UsuarioService {
    //Inyeccion por propiedad, poco recomendada por herramientas ya que es poco seguro
    //
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponse> findAll() {
        return UsuarioMapper.mapListEntityToListDto(usuarioRepository.findAll());
    }

    //Metodo FIndById

    @Override
    /*public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }*/

    public UsuarioResponse findById(Long id) {
        return UsuarioMapper.mapEntityToDto(usuarioRepository.findById(id).get());
    }

    //Metodo guardar usuario

    @Override
    /*public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }*/
    public UsuarioResponse save(UsuarioRequest usuarioRequest) {
        return UsuarioMapper.mapEntityToDto(usuarioRepository.save(UsuarioMapper.mapDtoToEntity(usuarioRequest)));
    }


    // Buscar el usuario por id y guardar los cambios
    @Override
    /*public Usuario update(Long id, Usuario updatedUsuario) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setName(updatedUsuario.getName());
            usuario.setLastName(updatedUsuario.getLastName());
            usuario.setEmail(updatedUsuario.getEmail());
            usuario.setPassword(updatedUsuario.getPassword());
            usuario.setBirth_day(updatedUsuario.getBirth_day());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new DataAccessException("Error al actualizar usuario con ID: " + id) {

        });
    }*/
    public UsuarioResponse update(Long id, UsuarioRequest updatedUsuario) {

        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setName(updatedUsuario.getName());
            usuario.setLastName(updatedUsuario.getLastName());
            usuario.setEmail(updatedUsuario.getEmail());
            usuario.setPassword(updatedUsuario.getPassword());
            usuario.setBirth_day(updatedUsuario.getBirth_day());
            return UsuarioMapper.mapEntityToDto(usuarioRepository.updateAudit(usuario));
        }).orElseThrow(() -> new DataAccessException("Error al actualizar usuario con ID: " + id) {

        });
    }

    //Emplea el metodo deleteById para eliminar registros por su ID
    @Override
    /*public Usuario delete(Long id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuarioRepository.delete(usuario);
            return usuario; // Devuelve el usuario eliminado
        }).orElseThrow(() -> new DataAccessException("Usuario no encontrado con ID: " + id){

        });
    }*/

    public UsuarioResponse delete(Long id) {
        return UsuarioMapper.mapEntityToDto(usuarioRepository.findById(id).map(usuario -> {
            usuarioRepository.deleteByIdActive(id);
            return usuario; // Devuelve el usuario eliminado
        }).orElseThrow(() -> new DataAccessException("Error al eliminar usuario con ID: " + id){

        }));
    }
}
