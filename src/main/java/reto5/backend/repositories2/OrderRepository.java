package reto5.backend.repositories2;
import reto5.backend.models.Order;
import reto5.backend.repositories.crud.IOrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author dario
 */
@Repository
public class OrderRepository {
    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    /**
     * OrderR
     */
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 
     * @return 
     */
    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }
    /**
     * 
     * @param order
     * @return 
     */
    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }
    /**
     * 
     * @param order 
     */
    public void update(Order order) {
        orderCrudRepository.save(order);
    }
    /**
     * 
     * @param order 
     */
    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    /**
     * 
     * @return 
     */
    public Optional<Order> lastUserId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * 
     * @param zona
     * @return 
     */
    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    /**
     * 
     * @param id
     * @return 
     */
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id);
        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
    }
    /**
     * 
     * @param dateStr
     * @param id
     * @return 
     */
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);
        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
    }
    /**
     * 
     * @param state
     * @param id
     * @return 
     */
    public List<Order> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);
        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
    }
}
