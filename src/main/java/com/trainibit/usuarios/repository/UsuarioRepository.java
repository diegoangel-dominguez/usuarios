package com.trainibit.usuarios.repository;

import com.trainibit.usuarios.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Repository
public interface UsuarioRepository extends AuditableRepository<Usuario, Long> { //Integer porque no acepta datos primitivos
    //Sobre escritura de methods
    //Crea una implementacion del metodo deletedByID
    @Override
    default void deleteByIdActive(Long id) {
        Usuario entity = findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        entity.setActive(false);
        save(entity);
    }

    @Override
    default Usuario updateAudit(Usuario entity) {
        entity.setUpdatedAt(Timestamp.from(Instant.now()));
        return save(entity);

    }
}
