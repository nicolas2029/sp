package person.pract.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import person.pract.models.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
