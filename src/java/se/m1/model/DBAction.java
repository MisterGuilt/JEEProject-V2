/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static se.m1.Constants.*;
import se.m1.Employee;
import se.m1.User;

/**
 *
 * @author JAA
 */
public class DBAction {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ArrayList<User> listUsers;
    ArrayList<Employee> listEmployees;

    public DBAction() {
        try {
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public Statement getStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return stmt;

    }

    public ResultSet getResultSet(String query) {
        stmt = getStatement();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return rs;

    }

    public ArrayList<User> getUsers() {
        listUsers = new ArrayList<>();
        rs = getResultSet(SEL_QUERY_CREDENTIALS);
        try {
            while (rs.next()) {
                User userBean = new User();
                userBean.setLogin(rs.getString("LOGIN"));
                userBean.setPassword(rs.getString("PWD"));

                listUsers.add(userBean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listUsers;
    }

    public ArrayList<Employee> getEmployees() {
        listEmployees = new ArrayList<>();
        rs = getResultSet(QUERY_SEL_EMPLOYEES);
        try {
            while (rs.next()) {
                Employee emplBean = new Employee();
                emplBean.setId(rs.getString("ID"));
                emplBean.setFirstname(rs.getString("FIRSTNAME"));
                emplBean.setName(rs.getString("NAME"));
                emplBean.setAddress(rs.getString("ADRESS"));
                emplBean.setCity(rs.getString("CITY"));
                emplBean.setMail(rs.getString("EMAIL"));

                listEmployees.add(emplBean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listEmployees;
    }
    
       public ArrayList<Employee> getAnEmployees(Employee anEmployee) {
        listEmployees = new ArrayList<>();
        System.out.println(anEmployee.getId());
        String rst = "SELECT * from EMPLOYEES WHERE id=" + anEmployee.getId()+"";
        
        rs = getResultSet(rst);
        try {
            while (rs.next()) {
                Employee emplBean = new Employee();
                emplBean.setFirstname(rs.getString("FIRSTNAME"));
                emplBean.setName(rs.getString("NAME"));
                emplBean.setAddress(rs.getString("ADRESS"));
                emplBean.setCity(rs.getString("CITY"));
                emplBean.setMail(rs.getString("EMAIL"));

                listEmployees.add(emplBean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listEmployees;
    }

    /**
     *
     * @param userInput
     * @return
     */
    public boolean checkCredentials(User userInput) {
        boolean testCheck = false;
        listUsers = getUsers();

        for (User userBase : listUsers) {
            if (userBase.getLogin().equals(userInput.getLogin())
                    && userBase.getPassword().equals(userInput.getPassword())) {
                testCheck = true;
            }
        }
        return testCheck;
    }
    
    public void AddEmployee(Employee aEmployee)
    {
        try {
            PreparedStatement st = conn.prepareStatement(QUERY_ADD_EMPLOYEES);
            st.setString(1, aEmployee.getName());
            st.setString(2, aEmployee.getFirstname());
            st.setString(3, aEmployee.getHomePhone());
            st.setString(4, aEmployee.getMobilePhone());
            st.setString(5, aEmployee.getProPhone());
            st.setString(6, aEmployee.getAddress());
            st.setString(7, aEmployee.getPostalCode());
            st.setString(8, aEmployee.getCity());
            st.setString(9, aEmployee.getMail());
            
            st.execute(); 
            System.out.println("Data Successful");
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteEmployee(Employee anEmployee) {

        try {
            String rst = "DELETE from EMPLOYEES WHERE id=" + anEmployee.getId()+"";
            PreparedStatement st = conn.prepareStatement(rst);           
            st.execute(); 
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateEmployee(Employee aEmployee)
    {
         try {
            PreparedStatement st = conn.prepareStatement(QUERY_UPDATE_EMPLOYEE);
            st.setString(1, aEmployee.getName());
            st.setString(2, aEmployee.getFirstname());
            st.setString(3, aEmployee.getHomePhone());
            st.setString(4, aEmployee.getMobilePhone());
            st.setString(5, aEmployee.getProPhone());
            st.setString(6, aEmployee.getAddress());
            st.setString(7, aEmployee.getPostalCode());
            st.setString(8, aEmployee.getCity());
            st.setString(9, aEmployee.getMail());
            st.setString(10, aEmployee.getId());
            st.execute(); 
            System.out.println("Data Successful");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
