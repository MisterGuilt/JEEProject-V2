package se.m1.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session bean for the Employees entity
 */
@Stateless
public class EmployeesSB {
@PersistenceContext
    EntityManager em;

    /**
     * Returns a list of all the employees in the database
     * @return
     *      A list of all the employees
     */
    public List getEmployees()
    {
        Query q = em.createQuery("SELECT e FROM Employees e");
        return q.getResultList();
    }
    
    /**
     * Returns a specific employee from the database
     * @param employeeId
     *      The desired employee's ID
     * @return The employee that matches the ID
     */
    public Employees getAnEmployee(int employeeId)
    {
        Query q = em.createQuery("SELECT e FROM Employees e WHERE e.id = :id");
        return (Employees) q.setParameter("id", employeeId).getSingleResult();
    }

    /**
     * Deletes an employee from the database
     * @param employeeID
     *      The ID of the employee to be deleted
     */
    public void deleteEmployee(int employeeID)
    {
       Query query = em.createQuery("DELETE FROM Employees e WHERE e.id = :id");
       query.setParameter("id", employeeID);
       query.executeUpdate();
    }
          
    /**
     * Adds an employee to the database
     * @param myEmployee
     *      Employee data to add
     */
    public void addEmployee(Employees myEmployee)
    {
        em.persist(myEmployee);
    }
    
    /**
     * Modifies an employee's info in the database
     * @param myEmployee
     *      Employee data to modify
     */
    public void updateEmployee(Employees myEmployee)
    {
        em.merge(myEmployee);
    }
}
