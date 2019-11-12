package se.m1.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import javax.persistence.Query;

/**
 * Session bean for the User entity
 */
@Stateless
public class UserSB {

    @PersistenceContext
    EntityManager em;
    
    List<User> listUsers;
    User validUser;
    
    /**
     * Returns a list of the users in the database
     * @return A list of all the users
     */
    public List getUsers()
    {
        Query q = em.createQuery("SELECT u FROM User u");
        return q.getResultList();
    }
    
    /**
     * Verifies if the credentials entered match a user in the database
     * @param userInput
     *      The credentials entered by the user
     * @return A user matching the credentials
     */
    public User checkCredentials(User userInput) {
        listUsers = getUsers();

        for (User userBase : listUsers) {
            if (userBase.getLogin().equals(userInput.getLogin())
                    && userBase.getPwd().equals(userInput.getPwd())) {
                validUser = userBase;
            }
        }
        return validUser;
    }
}
