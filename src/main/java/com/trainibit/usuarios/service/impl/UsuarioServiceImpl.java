package com.trainibit.usuarios.service.impl;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.mapper.UsuarioMapper;
import com.trainibit.usuarios.mapper.UsuarioMapper2;
import com.trainibit.usuarios.repository.UsuarioRepository;
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;
import com.trainibit.usuarios.service.PlanetService;
import com.trainibit.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


//Este estereotipo siempre va en la implementacion de la interface

@Service
public class UsuarioServiceImpl implements UsuarioService {
    //Inyeccion por propiedad, poco recomendada por herramientas ya que es poco seguro
    //
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioResponse> findAll() {
        //return UsuarioMapper2.mapListEntityToListDto(usuarioRepository.findByActiveTrue());
        return null;
    }

    //Metodo FIndById

    @Override
    /*public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }*/

    public UsuarioResponse findById(UUID uuid) {
       // return UsuarioMapper.mapEntityToDto(usuarioRepository.findById(id).get());
        return usuarioRepository.findByUuid(uuid)
                .filter(Usuario::getActive)
                .map(usuarioMapper::mapEntityToDto)
                .orElseThrow(() -> new DataAccessException("Usuario con ID " + uuid + " no encontrado") {

        });
    }

    //Metodo guardar usuario

    @Override
    /*public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }*/
    public UsuarioResponse save(UsuarioRequest usuarioRequest) {

        Usuario usuario = UsuarioMapper2.mapDtoToEntity(usuarioRequest);
        usuario.setPlaneta(getNamePlanet());

        Usuario savedUsuario = usuarioRepository.save(usuario);

        return UsuarioMapper2.mapEntityToDto(savedUsuario);

        // return UsuarioMapper.mapEntityToDto(usuarioRepository.save(UsuarioMapper.mapDtoToEntity(usuarioRequest)));
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
    public UsuarioResponse update(UUID uuid, UsuarioRequest updatedUsuario) {

        return usuarioRepository.findByUuid(uuid).map(usuario -> {
            usuario.setName(updatedUsuario.getName());
            usuario.setLastName(updatedUsuario.getLastName());
            usuario.setEmail(updatedUsuario.getEmail());
            usuario.setPassword(updatedUsuario.getPassword());
            usuario.setBirth_day(updatedUsuario.getBirth_day());
            return UsuarioMapper2.mapEntityToDto(usuarioRepository.updateAudit(usuario));
        }).orElseThrow(() -> new DataAccessException("Error al actualizar usuario con ID: " + uuid) {

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

    public UsuarioResponse delete(UUID uuid) {
        return UsuarioMapper2.mapEntityToDto(usuarioRepository.findByUuid(uuid).map(usuario -> {

            usuarioRepository.deleteByIdActive(uuid);
            return usuario; // Devuelve el usuario eliminado
        }).orElseThrow(() -> new DataAccessException("Error al eliminar usuario con ID: " + uuid){

        }));
    }

    private String getNamePlanet() {
        int idPlaneta = (int) (Math.random() * 60) + 1;
        return planetService.getPlanetById(idPlaneta).getResult().getProperties().getName();
    }
}
