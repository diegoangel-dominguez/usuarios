package com.trainibit.usuarios.repository;

import com.trainibit.usuarios.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends AuditableRepository<Usuario, Long> { //Integer porque no acepta datos primitivos
    //Sobre escritura de methods

    List<Usuario> findByActiveTrue(); // Filtra usuarios donde active = true

    //Crea una implementacion del metodo deletedByID
    @Override
    default void deleteByIdActive(Long id) {
        Usuario entity = findById(id).orElseThrow(() -> new RuntimeException("Id not found"));

        if (!entity.isActive()) {
            throw new IllegalStateException("El usuario ya está desactivado.");
        }

        entity.setActive(false);
        entity.setUpdatedAt(Timestamp.from(Instant.now()));

        save(entity);
    }

    @Override
    default Usuario updateAudit(Usuario entity) {

        //System.out.println("Actualizando timestamp en updateAudit: " + Instant.now());

        entity.setUpdatedAt(Timestamp.from(Instant.now()));
        //System.out.println("Guardando entidad con updatedAt: " + entity.getUpdatedAt());
        //System.out.println(entity);

        return save(entity);

    }
}
