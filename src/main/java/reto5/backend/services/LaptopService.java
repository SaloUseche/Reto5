package reto5.backend.services;
import reto5.backend.models.Laptop;
import reto5.backend.repositories2.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;
/**
 * 
 * @author dario
 */
@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repositorio;
    /**
     * 
     * @return 
     */
    public List<Laptop> listar() {
        return repositorio.getAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Laptop> getById(Integer id) {
        return repositorio.getById(id);
    }
    /**
     * 
     * @param laptop
     * @return 
     */
    public Laptop create(Laptop laptop) {
        if (laptop.getId() == null) {
            return laptop;
        }
        return repositorio.save(laptop);
    }
    /**
     * 
     * @param laptop
     * @return 
     */
    public Laptop update(Laptop laptop) {
        if (laptop.getId() != null) {
            Optional<Laptop> laptopDb = repositorio.getById(laptop.getId());
            if (!laptopDb.isEmpty()) {
                if (laptop.getBrand() != null) {
                    laptopDb.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel() != null) {
                    laptopDb.get().setModel(laptop.getModel());
                }
                if (laptop.getProcesor() != null) {
                    laptopDb.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs() != null) {
                    laptopDb.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription() != null) {
                    laptopDb.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory() != null) {
                    laptopDb.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive() != null) {
                    laptopDb.get().setHardDrive(laptop.getHardDrive());
                }
                if (laptop.isAvailability() != false || laptop.isAvailability() != true) {
                    // en caso que sea un valor incorrecto, o sea si es diferente de true or false
                    //entonces es un valor invalido
                    laptopDb.get().setAvailability(laptop.isAvailability());
                }
                if (laptop.getPhotography() != null) {
                    laptopDb.get().setPhotography(laptop.getPhotography());
                }
                laptopDb.get().setPrice(laptop.getPrice());
                laptopDb.get().setQuantity(laptop.getQuantity());
                repositorio.update(laptopDb.get());
                return laptopDb.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }
    /**
     * 
     * @param userId
     * @return 
     */
    public boolean delete(int userId) {
        Optional<Laptop> laptop = repositorio.getById(userId);
        if (laptop.isEmpty()){
            return false;
        }else{
            repositorio.delete(userId);
            return true;
        }
    }
    /**
     * 
     * @param price
     * @return 
     */
    public List<Laptop> gadgetsByPrice(double price) {
        return repositorio.gadgetsByPrice(price);
    }
    /**
     * 
     * @param description
     * @return 
     */
    public List<Laptop> findByDescriptionLike(String description) {
        return repositorio.findByDescriptionLike(description);
    }
}
