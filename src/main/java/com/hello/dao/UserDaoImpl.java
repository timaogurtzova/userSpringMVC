package com.hello.dao;

import com.hello.exception.DBException;
import com.hello.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private Session session;

    UserDaoImpl() {
    }

    @Override
    public List<User> getAllUser() throws DBException {
        List<User> users;
        Query<User> query = session.createQuery("SELECT user FROM User user");
        users = query.list();
        return users;
    }

    @Override
    public User getUserById(long id) throws DBException {
        User user;
        user = session.find(User.class, id);
        return user;
    }

    @Override
    public User getUserWithNameAndPassword(String name, String password) throws DBException {
        Query query = session.createQuery(
                    "SELECT u FROM User u WHERE u.name =:nameUser AND u.password =:passwordUser ")
                    .setParameter("nameUser", name)
                    .setParameter("passwordUser", password)
                    .setMaxResults(1);
            User user = (User) query.uniqueResult();

        return user;
    }

    @Override
    public void updateUserById(User newParameterUser) throws DBException {
            session.update(newParameterUser);
    }

    @Override
    public void addUser(User user) throws DBException {
            session.save(user);
    }

    @Override
    public void deleteUserById(long id) throws DBException {
        Query query = session.createQuery("DELETE FROM User WHERE id =:param");
        query.setParameter("param", id);
        query.executeUpdate();
    }
}