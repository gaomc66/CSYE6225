package com.mengchen.assignment2.dao;

import com.mengchen.assignment2.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<User> listAllUser() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a Query
        // this point needs to add support framework (Hibernate)
        Query<User> theQuery =
                currentSession.createQuery("from User", User.class);

        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findByEmail(String theEmail) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("from User where email=:theEmail", User.class);

        theQuery.setParameter("theEmail", theEmail);
        User userResult = (User) theQuery.uniqueResultOptional().orElse(null);

        return userResult;
    }

    @Override
    public void createUser(User theUser) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(theUser);
    }

    @Override
    public void updateUser(User theUser) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.update(theUser);
    }

    @Override
    public void deleteUser(String theEmail) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("delete from User where email=:theEmail", User.class);
        theQuery.setParameter("theEmail", theEmail);
        theQuery.executeUpdate();
    }

}
