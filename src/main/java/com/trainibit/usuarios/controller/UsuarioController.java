package com.trainibit.usuarios.controller;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

public class UsuarioController {
    //Inyeccion de la interface @Service
    @Autowired
    private UsuarioService usuarioService;

    //Path para llamar al servicio

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {

        return ResponseEntity.ok(usuarioService.findAll());


    }

    //GetlMapping {id}
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }
    //Metodo para consultar por id FindById

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        //Codigo de estatus HTTP 201
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    //Endpoint PutMapping
    @PutMapping("/{id}")

    // Recibe el ID como pathvariable y el objeto actualizado en el cuerpo de la solicitud (@RequestBody).
    public ResponseEntity<Usuario> updateUser(
            @PathVariable Long id,
            @RequestBody Usuario userUpdate) {
        Usuario usuario = usuarioService.update(id, userUpdate);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    // Este recibe el ID del usuario como parámetro de la ruta (@PathVariable).
    public ResponseEntity<Usuario> deleteUser(@PathVariable Long id){
    Usuario deleteUser = usuarioService.delete(id);
    //Codigo de estatus HTTP 204
    return ResponseEntity.ok(deleteUser);
    }
    //@PostMapping

    //@DeleteMapping

    //@PutMapping

    //@GetMapping
}
