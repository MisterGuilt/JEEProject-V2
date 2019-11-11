package se.m1.model;

/**
 *
 * @author Anil DEVADAS
 */
public class Constants {
    
    //Database data
    public static final String URL = "jdbc:derby://localhost:1527/JEEDB";
    public static final String USER = "jee";
    public static final String PWD = "jee";
    
    //JSP URLs
    public static final String JSP_HOME_PAGE = "home.jsp";
    public static final String JSP_WELCOME_PAGE = "/WEB-INF/welcome.jsp";
    public static final String JSP_ADD_PAGE = "/WEB-INF/addEmployee.jsp";
    public static final String JSP_DETAIL_PAGE = "/WEB-INF/detailEmployee.jsp";
    public static final String JSP_GOODBYE_PAGE = "/WEB-INF/goodbye.jsp";
    
    //Login form field names and messages
    public static final String FRM_USERNAME_FIELD = "loginField";
    public static final String FRM_PWD_FIELD = "pwdField";
    
    //Error messages
    public static final String ERR_INVALID_CREDENTIALS = "Invalid credentials";
    public static final String ERR_NO_EMPLOYEES = "The company has no employees!";
    
    //Employee form field names
    public static final String FRM_EMPLOYEE_ID = "id";
    public static final String FRM_EMPLOYEE_NAME = "name";
    public static final String FRM_EMPLOYEE_FIRSTNAME = "firstname";
    public static final String FRM_EMPLOYEE_TELHOME = "homephone";
    public static final String FRM_EMPLOYEE_TELMOB = "mobilephone";
    public static final String FRM_EMPLOYEE_TELPRO = "mobilepro";
    public static final String FRM_EMPLOYEE_ADDRESS = "address";
    public static final String FRM_EMPLOYEE_POSTALCODE = "postalcode";
    public static final String FRM_EMPLOYEE_CITY = "city";
    public static final String FRM_EMPLOYEE_EMAIL = "email";
    
    //Select credentials for authentication
    public static final String QUERY_SELECT_CREDENTIALS = "SELECT * from CREDENTIALS";
    
    //Select all employees
    public static final String QUERY_SELECT_ALL_EMPLOYEES = "SELECT * from EMPLOYEES";
    
    //Add an employee
    public static final String QUERY_ADD_EMPLOYEES = "INSERT INTO JEE.EMPLOYEES (NAME, FIRSTNAME, TELHOME, TELMOB, TELPRO, ADRESS, POSTALCODE, CITY, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    //Update an employee record
    public static final String QUERY_UPDATE_EMPLOYEE = "UPDATE JEE.EMPLOYEES SET NAME = ?, FIRSTNAME = ?, TELHOME = ?, TELMOB = ?, TELPRO = ?, ADRESS = ?, POSTALCODE = ?, CITY = ?, EMAIL = ? WHERE ID = ?";
    
    //Delete an employee record
    public static final String QUERY_DELETE_EMPLOYEE = "DELETE from EMPLOYEES WHERE id=";
    
    //Select an employee
    public static final String QUERY_SELECT_EMPLOYEE = "SELECT * from EMPLOYEES WHERE id=";
}
