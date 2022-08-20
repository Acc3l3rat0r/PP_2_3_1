package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    private final EntityManagerFactory entityManagerFactory;

    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void add(User user) {
        entityManagerFactory.createEntityManager().persist(user);
    }

    @Override
    public void delete(User user) {
        entityManagerFactory.createEntityManager().remove(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> allUsers() {
        return entityManagerFactory.createEntityManager().createQuery("from User",User.class).getResultList();
    }
}
