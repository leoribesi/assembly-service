package com.assembly.assembly_service.session.vote.register;

import com.assembly.assembly_service.shared.entities.VoteEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterVoteRepository extends JpaRepository<VoteEntity, Long> {

    @EntityGraph(attributePaths = {"session", "associate"})
    @Query(value = """
    SELECT v FROM VoteEntity v
    WHERE v.session.id = :sessionId
    AND v.associate.id = :associateId
    """)
    Optional<VoteEntity> findVote(Long sessionId, Long associateId);
}
