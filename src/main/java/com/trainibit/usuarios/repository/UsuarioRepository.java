package com.trainibit.usuarios.repository;

import com.trainibit.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //Integer porque no acepta datos primitivos

}
