package person.pract.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import person.pract.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
