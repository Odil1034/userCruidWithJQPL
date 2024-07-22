package uz.pdp.maven.usercruidwithjpql.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import uz.pdp.maven.usercruidwithjpql.entity.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class UserRepository implements BaseRepository<User> {

    public User login(String username, String email, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userCrud");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createNamedQuery("loginQuery", User.class);
        query.setParameter("username", username);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return query.getSingleResult();
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
}
