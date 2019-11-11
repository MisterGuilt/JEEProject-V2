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
import static se.m1.model.Constants.*;
import se.m1.model.beans.Employee;
import se.m1.model.beans.User;

public class DBAction {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ArrayList<User> listUsers;
    ArrayList<Employee> listEmployees;
    PreparedStatement st;

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
        rs = getResultSet(QUERY_SELECT_CREDENTIALS);
        try {
            while (rs.next()) {
                User userBean = new User();
                userBean.setUsername(rs.getString("LOGIN"));
                userBean.setPassword(rs.getString("PWD"));
                userBean.setRank(rs.getString("RANK"));

                listUsers.add(userBean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listUsers;
    }

    public ArrayList<Employee> getEmployees() {
        listEmployees = new ArrayList<>();
        rs = getResultSet(QUERY_SELECT_ALL_EMPLOYEES);
        try {
            while (rs.next()) {
                Employee oneEmployee = new Employee();
                oneEmployee.setId(rs.getInt("ID"));
                oneEmployee.setName(rs.getString("NAME"));
                oneEmployee.setFirstname(rs.getString("FIRSTNAME"));
                oneEmployee.setHomePhone(rs.getString("TELHOME"));
                oneEmployee.setMobilePhone(rs.getString("TELMOB"));
                oneEmployee.setProPhone(rs.getString("TELPRO"));
                oneEmployee.setAddress(rs.getString("ADRESS"));
                oneEmployee.setPostalCode(rs.getString("POSTALCODE"));
                oneEmployee.setCity(rs.getString("CITY"));
                oneEmployee.setMail(rs.getString("EMAIL"));
                listEmployees.add(oneEmployee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listEmployees;
    }
    
       public Employee getOneEmployee(int employeeId) {
        Employee specificEmployee = new Employee();
        try {
            st = conn.prepareStatement(QUERY_SELECT_EMPLOYEE + employeeId);
            rs = st.executeQuery();
            rs.next();
            
            specificEmployee.setId(rs.getInt("ID"));
            specificEmployee.setName(rs.getString("NAME"));
            specificEmployee.setFirstname(rs.getString("FIRSTNAME"));
            specificEmployee.setHomePhone(rs.getString("TELHOME"));
            specificEmployee.setMobilePhone(rs.getString("TELMOB"));
            specificEmployee.setProPhone(rs.getString("TELPRO"));
            specificEmployee.setAddress(rs.getString("ADRESS"));
            specificEmployee.setPostalCode(rs.getString("POSTALCODE"));
            specificEmployee.setCity(rs.getString("CITY"));
            specificEmployee.setMail(rs.getString("EMAIL"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return specificEmployee;
    }

    /**
     *
     * @param userInput
     * @return
     */
    public User checkCredentials(User userInput) {
        listUsers = getUsers();
        User validUser = null;

        for (User userBase : listUsers) {
            if (userBase.getUsername().equals(userInput.getUsername())
                    && userBase.getPassword().equals(userInput.getPassword())) {
                validUser = userBase;
            }
        }
        return validUser;
    }
    
    public void AddEmployee(Employee aEmployee)
    {
        try {
            st = conn.prepareStatement(QUERY_ADD_EMPLOYEES);
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
            st = conn.prepareStatement(QUERY_DELETE_EMPLOYEE + anEmployee.getId());           
            st.execute();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateEmployee(Employee aEmployee)
    {
         try {
            st = conn.prepareStatement(QUERY_UPDATE_EMPLOYEE);
            st.setString(1, aEmployee.getName());
            st.setString(2, aEmployee.getFirstname());
            st.setString(3, aEmployee.getHomePhone());
            st.setString(4, aEmployee.getMobilePhone());
            st.setString(5, aEmployee.getProPhone());
            st.setString(6, aEmployee.getAddress());
            st.setString(7, aEmployee.getPostalCode());
            st.setString(8, aEmployee.getCity());
            st.setString(9, aEmployee.getMail());
            st.setInt(10, aEmployee.getId());
            st.execute(); 
            System.out.println("Data Successful");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
