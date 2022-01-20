package kaya.springframework.FlightSearch.repository;

import kaya.springframework.FlightSearch.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
