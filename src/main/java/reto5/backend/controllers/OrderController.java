package reto5.backend.controllers;
import reto5.backend.models.Order;
import reto5.backend.services.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author dario
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }
    /**
     * 
     * @param gadget
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }
    /**
     * 
     * @param gadget
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }
    /**
     * 
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }
    /**
     * 
     * @param zona
     * @return 
     */
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona){
        return orderService.findByZone(zona);
    }
    /**
     * 
     * @param id
     * @return 
     */
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id") int id) {
        return orderService.ordersSalesManByID(id);
    }
    /**
     * 
     * @param date
     * @param id
     * @return 
     */
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String date, @PathVariable("id") int id) {
        return orderService.ordersSalesManByDate(date, id);
    }
    /**
     * 
     * @param date
     * @param id
     * @return 
     */
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String date, @PathVariable("id") int id) {
        return orderService.ordersSalesManByState(date, id);
    }
}
