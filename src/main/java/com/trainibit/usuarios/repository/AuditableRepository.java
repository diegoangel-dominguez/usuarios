package com.trainibit.usuarios.repository;

import com.trainibit.usuarios.entity.AuditableRecord;
import com.trainibit.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface AuditableRepository<T, ID> extends JpaRepository<T, ID> {

    void deleteByIdActive(UUID uuid);

    Usuario updateAudit(Usuario entity);
}
