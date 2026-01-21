package com.assembly.assembly_service.associate.create;

import com.assembly.assembly_service.shared.entities.AssociateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateAssociateRepository extends JpaRepository<AssociateEntity, Long> {
}
