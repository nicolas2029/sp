package person.pract.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import person.pract.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User AS u LEFT JOIN FETCH u.cards LEFT JOIN FETCH u.roles where u.id = ?1")
    public User getUserWithRolesAndCards(long userId);

    // @Query("select v from ap_order_paid as v join fetch v.order where
    // v.cheqe_number like %?1%")
    // List<ApOrderPaid> getOrderTaskPaidByCheqNo(String cheqe_number);
}
