package com.board.roma.entity.repository.role;

import com.board.roma.entity.member.Role;
import com.board.roma.entity.member.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
