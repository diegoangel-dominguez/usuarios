package com.trainibit.usuarios.controller;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.mapper.UsuarioMapper;
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;
import com.trainibit.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/usuarios")
@Validated
public class UsuarioController {
    //Inyeccion de la interface @Service
    @Autowired
    private UsuarioService usuarioService;

    //Path para llamar al servicio

    /*@GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }
*/

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    //GetlMapping {id}


    /*@GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }*/
    //Metodo para consultar por id FindById
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@Valid @PathVariable Long id){
        UsuarioResponse searchedUser = usuarioService.findById(id);
        return ResponseEntity.ok(searchedUser);
    }

    @PostMapping
    /*public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        //Codigo de estatus HTTP 201
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }*/
    public ResponseEntity<UsuarioResponse> createUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
            Usuario usuario= UsuarioMapper.mapDtoToEntity(usuarioRequest);

            UsuarioResponse createdUser = usuarioService.save(usuario);
            //Codigo de estatus HTTP 201
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

    }

    //Endpoint PutMapping
    @PutMapping("/{id}")

    // Recibe el ID como pathvariable y el objeto actualizado en el cuerpo de la solicitud (@RequestBody).
    /*public ResponseEntity<Usuario> updateUser(
            @PathVariable Long id,
            @RequestBody Usuario userUpdate) {
        Usuario usuario = usuarioService.update(id, userUpdate);
        return ResponseEntity.ok(usuario);
    }*/

    public ResponseEntity<UsuarioResponse> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = UsuarioMapper.mapDtoToEntity(usuarioRequest);

        UsuarioResponse editedUser = usuarioService.update(id, usuario);
        return ResponseEntity.ok(editedUser);
    }

    @DeleteMapping("/{id}")
    // Este recibe el ID del usuario como parámetro de la ruta (@PathVariable).
    /*public ResponseEntity<Usuario> deleteUser(@PathVariable Long id){
    Usuario deleteUser = usuarioService.delete(id);
    //Codigo de estatus HTTP 204
    return ResponseEntity.ok(deleteUser);
    }*/

    public ResponseEntity<UsuarioResponse> deleteUser(@Valid @PathVariable Long id){
        UsuarioResponse deleteUser = usuarioService.delete(id);
        //Codigo de estatus HTTP 204
        return ResponseEntity.ok(deleteUser);
    }

    //@PostMapping

    //@DeleteMapping

    //@PutMapping

    //@GetMapping
}
