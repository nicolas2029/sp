package person.pract.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import person.pract.models.Bank;

@Repository
public interface BankRepo extends JpaRepository<Bank, Long> {

}
