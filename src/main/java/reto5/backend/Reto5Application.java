package reto5.backend;
import reto5.backend.models.Laptop;
import reto5.backend.models.Order;
import reto5.backend.models.User;
import reto5.backend.repositories.crud.IOrderCrudRepository;
import reto5.backend.repositories.crud.IUserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reto5.backend.repositories.crud.ILaptopCrudRepository;
/**
 * 
 * @author dario
 */
@SpringBootApplication
public class Reto5Application implements CommandLineRunner {
    @Autowired
    private ILaptopCrudRepository crudRepository;
    @Autowired
    private IUserCrudRepository userCrudRepository;
    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        SpringApplication.run(Reto5Application.class, args);
    }
    /**
     * 
     * @param args
     * @throws Exception 
     */
    @Override
    public void run(String... args) throws Exception {

        crudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Listado de ordenes");
        orderCrudRepository.findAll().forEach(System.out::println);              
    }
}
