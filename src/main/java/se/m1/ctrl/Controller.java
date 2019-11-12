package se.m1.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.m1.model.Employees;
import se.m1.model.EmployeesSB;
import se.m1.model.User;
import se.m1.model.UserSB;
import static se.m1.utls.Constants.*;

public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private UserSB userSB;
    ArrayList<User> listOfUsers;
    @EJB
    private EmployeesSB employeeSB;
    ArrayList<Employees> listOfEmployees;
    Employees myEmployee;
    User userInput;
    User validUser;
    HttpSession currentSession;
    boolean isAdmin;
    int employeeId;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listOfUsers = new ArrayList<>();
        listOfUsers.addAll(userSB.getUsers());

        currentSession = request.getSession(false);
        
        //If the user tries to log in
        if(request.getParameter("connection") != null)
        {
            //Data entered by the user is placed into an object
            userInput = new User();
            userInput.setLogin(request.getParameter(FRM_USERNAME_FIELD));
            userInput.setPwd(request.getParameter(FRM_PWD_FIELD));
            
            //Check if the credentials are valid
            validUser = userSB.checkCredentials(userInput);
            
            //If the credentials are valid, create a session
            if (validUser != null) {
                currentSession = request.getSession();
                //Store the user object in the session to use its data later
                currentSession.setAttribute("user", validUser);
                
                redirectToWelcome(request, response);
            } else {
                //If the credentials are invalid, reload the login page
                //with an error message
                request.setAttribute("errKey", ERR_INVALID_CREDENTIALS);
                request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
            }
        }
        //If a session is active, go through possible form responses
        //and treat them accordingly
        else if (currentSession != null)
        {
            //Check if the current user is an administrator
            isAdmin = false;
            if(((User)(currentSession.getAttribute("user"))).getRank().equals("admin")) isAdmin = true;
            
            //Going to the Add Employee page (Admin only)
            if (request.getParameter("add") != null)
            {
                //If the user is not an administrator, forbid the action
                //and redirect
                if (isAdmin == false)
                {
                    redirectToWelcome(request, response);
                }
                request.getRequestDispatcher(JSP_ADD_PAGE).forward(request, response);
            }
            //Trying to add an employee to the database (Admin only)
            else if (request.getParameter("addbutton") != null)
            {
                if (isAdmin == false)
                {
                    redirectToWelcome(request, response);
                }
                myEmployee = new Employees();
                myEmployee.setName(request.getParameter(FRM_EMPLOYEE_NAME));
                myEmployee.setFirstname(request.getParameter(FRM_EMPLOYEE_FIRSTNAME));
                myEmployee.setTelhome(request.getParameter(FRM_EMPLOYEE_TELHOME));
                myEmployee.setTelmob(request.getParameter(FRM_EMPLOYEE_TELMOB));
                myEmployee.setTelpro(request.getParameter(FRM_EMPLOYEE_TELPRO));
                myEmployee.setAdress(request.getParameter(FRM_EMPLOYEE_ADDRESS));
                myEmployee.setPostalcode(request.getParameter(FRM_EMPLOYEE_POSTALCODE));
                myEmployee.setCity(request.getParameter(FRM_EMPLOYEE_CITY));
                myEmployee.setEmail(request.getParameter(FRM_EMPLOYEE_EMAIL));

                employeeSB.addEmployee(myEmployee);
                redirectToWelcome(request, response);
            }
            //Viewing employee details
            else if (request.getParameter("detail") != null)
            {
                //Stop if no employee was selected
                if(request.getParameter(FRM_EMPLOYEE_ID) == null)
                {
                    redirectToWelcome(request, response);
                }
                else
                {
                    employeeId = Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID));
                    request.setAttribute("employee", employeeSB.getAnEmployee(employeeId));
                    request.getRequestDispatcher(JSP_DETAIL_PAGE).forward(request, response);
                }
            }
            //Clicking a cancel button
            else if (request.getParameter("cancel") != null)
            {
                redirectToWelcome(request, response);
            }
            //Trying to delete an employee from the database (Admin only)
            else if (request.getParameter("delete") != null)
            {
                if (isAdmin == false)
                {
                    redirectToWelcome(request, response);
                }
                //Stop if no employee was selected
                if(request.getParameter(FRM_EMPLOYEE_ID) == null)
                {
                    redirectToWelcome(request, response);
                }
                else
                {
                    employeeId = Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID));
                    employeeSB.deleteEmployee(employeeId);
                    redirectToWelcome(request, response);
                }
            }
            //Trying to update employee data (Admin only)
            else if (request.getParameter("update") != null)
            {
                if (isAdmin == false)
                {
                    redirectToWelcome(request, response);
                }
                myEmployee = new Employees();
                myEmployee.setId(Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID)));
                myEmployee.setName(request.getParameter(FRM_EMPLOYEE_NAME));
                myEmployee.setFirstname(request.getParameter(FRM_EMPLOYEE_FIRSTNAME));
                myEmployee.setTelhome(request.getParameter(FRM_EMPLOYEE_TELHOME));
                myEmployee.setTelmob(request.getParameter(FRM_EMPLOYEE_TELMOB));
                myEmployee.setTelpro(request.getParameter(FRM_EMPLOYEE_TELPRO));
                myEmployee.setAdress(request.getParameter(FRM_EMPLOYEE_ADDRESS));
                myEmployee.setPostalcode(request.getParameter(FRM_EMPLOYEE_POSTALCODE));
                myEmployee.setCity(request.getParameter(FRM_EMPLOYEE_CITY));
                myEmployee.setEmail(request.getParameter(FRM_EMPLOYEE_EMAIL));
                employeeSB.updateEmployee(myEmployee);
                redirectToWelcome(request, response);
            }
            //Logging out
            else if (request.getParameter("logout") != null)
            {
                request.getSession().invalidate();
                request.getRequestDispatcher(JSP_GOODBYE_PAGE).forward(request, response);
            }
        }
        //Just in case some freak accident happens, redirect to the login page
        else
        {
            request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
        }
    }
    
    /**
     * Redirects to the employee list. Was put into a separate method
     * because it is commonly used.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void redirectToWelcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        listOfEmployees = new ArrayList<>();
        listOfEmployees.addAll(employeeSB.getEmployees());
        if (listOfEmployees.isEmpty()) request.setAttribute("errKey", ERR_NO_EMPLOYEES);
        request.setAttribute("empList", listOfEmployees);
        request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
