package person.pract.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import person.pract.models.Thing;

@Repository
public interface ThingRepo extends JpaRepository<Thing, Long> {

}