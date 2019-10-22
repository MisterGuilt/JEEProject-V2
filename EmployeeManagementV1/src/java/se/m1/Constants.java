/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1;

/**
 *
 * @author Anil DEVADAS
 */
public class Constants {
    
    public static final String URL = "jdbc:derby://localhost:1527/JEEDB";
    public static final String USER = "jee";
    public static final String PWD="jee";
    public static final String SEL_QUERY_CREDENTIALS = "SELECT * from CREDENTIALS";
    public static final String ERR_MESSAGE = "Invalid credentials";
    public static final String QUERY_SEL_EMPLOYEES = "SELECT * from EMPLOYEES";
    public static final String JSP_HOME_PAGE = "home.jsp";
    public static final String JSP_WELCOME_PAGE = "welcome.jsp";
    public static final String JSP_ADD_PAGE = "addEmployee.jsp";
    public static final String FRM_LOGIN_FIELD = "loginField";
    public static final String FRM_PWD_FIELD = "pwdField";
    
    
    //For the Employee Formular
    public static final String FRM_EMPLOYEE_NAME = "name";
    public static final String FRM_EMPLOYEE_FIRSTNAME = "firstname";
    public static final String FRM_EMPLOYEE_TELHOME = "homephone";
    public static final String FRM_EMPLOYEE_TELMOB = "mobilephone";
    public static final String FRM_EMPLOYEE_TELPRO = "mobilepro";
    public static final String FRM_EMPLOYEE_ADRESS = "address";
    public static final String FRM_EMPLOYEE_POSTALCODE = "zipcode";
    public static final String FRM_EMPLOYEE_CITY = "city";
    public static final String FRM_EMPLOYEE_EMAIL = "email";
       
    
    //Add an employee
    public static final String QUERY_ADD_EMPLOYEES = "INSERT INTO JEE.EMPLOYEES (NAME, FIRSTNAME, TELHOME, TELMOB, TELPRO, ADRESS, POSTALCODE, CITY, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
}
