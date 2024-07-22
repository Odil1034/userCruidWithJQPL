package uz.pdp.maven.usercruidwithjpql.service.userService;

import jakarta.persistence.*;
import uz.pdp.maven.usercruidwithjpql.entity.user.User;
import uz.pdp.maven.usercruidwithjpql.repository.UserRepository;
import uz.pdp.maven.usercruidwithjpql.util.ValidationUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class UserServiceImp implements UserService {

    UserRepository userRepository = new UserRepository();

    @Override
    public User login(String username, String email, String password) {
        User login = userRepository.login(username, email, password);
        return login;
    }

    @Override
    public void signUp(User user) {
        String isValid = ValidationUtil.isValid(user);
        if (isValid.equals("true")){
            userRepository.save(user);
        }else {
            System.out.println(isValid);
        }
    }

    @Override
    public User get(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userCrud");
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public void save(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userCrud");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void delete(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userCrud");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userCrud");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User oldUser = em.find(User.class, user.getId());

        oldUser.setFirstName(Objects.requireNonNullElse(user.getFirstName(), oldUser.getFirstName()));
        oldUser.setLastName(Objects.requireNonNullElse(user.getLastName(), oldUser.getLastName()));
        oldUser.setUsername(Objects.requireNonNullElse(user.getUsername(), oldUser.getUsername()));
        oldUser.setPassword(Objects.requireNonNullElse(user.getPassword(), oldUser.getPassword()));
        oldUser.setEmail(Objects.requireNonNullElse(user.getEmail(), oldUser.getEmail()));
        oldUser.setAge(Objects.requireNonNullElse(user.getAge(), oldUser.getAge()));

        oldUser.setUpdatedAt(LocalDateTime.now());

        em.merge(oldUser);
        em.getTransaction().commit();
    }

    @Override
    public List<User> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userCrud");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> fromUser = em.createQuery("from User", User.class);
        List<User> users = fromUser.getResultList();
        return users;
    }

    private static UserService userService;

    public static UserService getInstance(){
        if (userService == null) {
            userService = new UserServiceImp();
        }
        return userService;
    }
}
