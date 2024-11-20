package com.trainibit.usuarios.service.impl;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.repository.UsuarioRepository;
import com.trainibit.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    //Metodo FIndById

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
