package reto5.backend.repositories.crud;
import reto5.backend.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * 
 * @author User
 */
public interface IUserCrudRepository extends MongoRepository<User, Integer> {
 public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findByMonthBirthtDay(String monthBirthtDay);
    Optional<User> findTopByOrderByIdDesc();
}
