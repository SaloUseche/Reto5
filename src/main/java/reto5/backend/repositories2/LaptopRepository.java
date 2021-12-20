package reto5.backend.repositories2;
import reto5.backend.models.Laptop;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto5.backend.repositories.crud.ILaptopCrudRepository;
/**
 * 
 * @author dario
 */
@Repository
public class LaptopRepository {
    @Autowired
    private ILaptopCrudRepository crudLaptopRepository;
    /**
     * 
     * @return 
     */
    public List<Laptop> getAll() {
        return crudLaptopRepository.findAll();        
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Laptop> getById(Integer id) {
        return crudLaptopRepository.findById(id);
    }
    /**
     * 
     * @param laptop
     * @return 
     */
    public Laptop save(Laptop laptop) {
        return crudLaptopRepository.save(laptop);
    }
    /**
     * 
     * @param laptop 
     */
    public void update(Laptop laptop) {
        crudLaptopRepository.save(laptop);
    }
    /**
     * 
     * @param id 
     */
    public void delete(Integer id) {
        crudLaptopRepository.deleteById(id);
    }
    /**
     * 
     * @param precio
     * @return 
     */
    public List<Laptop> gadgetsByPrice(double precio) {
        return crudLaptopRepository.findByPriceLessThanEqual(precio);
    }
    /**
     * 
     * @param description
     * @return 
     */
    public List<Laptop> findByDescriptionLike(String description) {
        return crudLaptopRepository.findByDescriptionLike(description);
    }
}
