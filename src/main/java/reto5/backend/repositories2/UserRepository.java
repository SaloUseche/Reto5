package reto5.backend.repositories2;
import reto5.backend.models.User;
import reto5.backend.repositories.crud.IUserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 * 
 * @author User
 */
@Repository
/**
 * UserR
 */
public class UserRepository {
    @Autowired
    private IUserCrudRepository userCrudRepository;
    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * 
     * @param user
     * @return 
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * 
     * @param user 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * 
     * @param user 
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);        
        return !usuario.isEmpty();
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * 
     * @return 
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * 
     * @param monthBirthtDay
     * @return 
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}