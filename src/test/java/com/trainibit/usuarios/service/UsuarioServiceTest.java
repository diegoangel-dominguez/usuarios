package com.trainibit.usuarios.service;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    public void shouldBeSaveSuccess() {


        //1. Arrange
        // Qué necesito yo para buscar por id a un usuario?

        //1.1 Definir entradas
        //1.2 definir salidas
        Usuario usuario = new Usuario();

        //1.3 Mockear comportamientos de las dependencias
        //when(usuarioRepository.findByUuid(anyInt())).thenReturn(usuario);



        //UUID uuid = "8fd4892f-593d-47dc-90b6-a160b9b07f25";



        // 2. Act



        //3. Assert



    }
}
