package kz.salta.ssdb.dao;

import kz.salta.ssdb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
