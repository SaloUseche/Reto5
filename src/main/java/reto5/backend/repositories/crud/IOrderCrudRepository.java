package reto5.backend.repositories.crud;
import reto5.backend.models.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
/**
 * 
 * @author dario
 */
public interface IOrderCrudRepository extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    Optional<Order> findTopByOrderByIdDesc();
}
