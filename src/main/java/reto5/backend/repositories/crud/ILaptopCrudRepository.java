package reto5.backend.repositories.crud;
import reto5.backend.models.Laptop;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
/**
 * 
 * @author dario
 */
public interface ILaptopCrudRepository extends MongoRepository<Laptop, Integer> {
     public List<Laptop> findByPriceLessThanEqual(double precio);
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Laptop> findByDescriptionLike(String description);    
}
