package person.pract.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import person.pract.models.Card;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {
    // @Query("SELECT c FROM Card c WHERE c.user.id = ?1")
    // List<Card> findByUserId(long id);
}
