package ru.max.springbootrestapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.max.springbootrestapp.models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
       User newUser = entityManager.merge(user);
       user.setId(newUser.getId());
    }

    @Override
    public void deleteUser(long id) {
//        if (findById(id) != null) {
//            User user = findById(id);
//            entityManager.remove(user);
//        }
        Query query = entityManager.createQuery("delete from User where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
