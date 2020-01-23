package com.mengchen.assignment2.dao;

import com.mengchen.assignment2.entity.User;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class UserDAOImplTest {

//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Test
//    public void whenFindAll() {
//        //given
//        User firstUser = new User();
//        firstUser.setId(UUID.randomUUID().toString());
//        firstUser.setEmail(RandomString.make(10));
//        firstUser.setFirstName(RandomString.make(10));
//        firstUser.setLastName(RandomString.make(10));
//        firstUser.setPassword(RandomString.make(10));
//        entityManager.persist(firstUser);
//        entityManager.flush();
//
//        //when
//        List<User> users = userDAO.listAllUser();
//
//        //then
//        Assert.assertEquals(users.size(), 2);
//    }
}
