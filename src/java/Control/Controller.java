/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.m1.User;
import se.m1.model.DBAction;
import static se.m1.Constants.*;
import se.m1.Employee;

/**
 * @author JAA
 */

public class Controller extends HttpServlet {
    DBAction dba;
     User userInput;
     Employee myEmployee;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dba = new DBAction();
        HttpSession currentSession = request.getSession(false);
        
        if(request.getParameter("connection") != null)
        {
            //Data entered by the user
            userInput = new User();
            userInput.setUsername(request.getParameter(FRM_USERNAME_FIELD));
            userInput.setPassword(request.getParameter(FRM_PWD_FIELD));
            
            User validUser = null;
            validUser = dba.checkCredentials(userInput);
            
            if (validUser != null) {
                currentSession = request.getSession();
                currentSession.setAttribute("user", validUser);
                
                request.setAttribute("empList", dba.getEmployees());
                request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
            } else {
                request.setAttribute("errKey", ERR_MESSAGE);
                request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
            }
        }
        else if (currentSession != null)
        {
            boolean isAdmin = false;
            if(((User)(currentSession.getAttribute("user"))).getRank().equals("admin")) isAdmin = true;
            
            if (request.getParameter("add") != null)
            {
                if (isAdmin == false)
                {
                    request.setAttribute("empList", dba.getEmployees());
                    request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
                }
                request.getRequestDispatcher(JSP_ADD_PAGE).forward(request, response);
            }
            else if (request.getParameter("addbutton") != null)
            {
                if (isAdmin == false) request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
                {
                    request.setAttribute("empList", dba.getEmployees());
                    request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
                }
                myEmployee = new Employee();
                myEmployee.setName(request.getParameter(FRM_EMPLOYEE_NAME));
                myEmployee.setFirstname(request.getParameter(FRM_EMPLOYEE_FIRSTNAME));
                myEmployee.setHomePhone(request.getParameter(FRM_EMPLOYEE_TELHOME));
                myEmployee.setMobilePhone(request.getParameter(FRM_EMPLOYEE_TELMOB));
                myEmployee.setProPhone(request.getParameter(FRM_EMPLOYEE_TELPRO));
                myEmployee.setAddress(request.getParameter(FRM_EMPLOYEE_ADDRESS));
                myEmployee.setPostalCode(request.getParameter(FRM_EMPLOYEE_POSTALCODE));
                myEmployee.setCity(request.getParameter(FRM_EMPLOYEE_CITY));
                myEmployee.setMail(request.getParameter(FRM_EMPLOYEE_EMAIL));

                dba.AddEmployee(myEmployee);
                request.setAttribute("empList", dba.getEmployees());
                request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
            }
            else if (request.getParameter("detail") != null)
            {
                int employeeId = Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID));
                request.setAttribute("employee", dba.getOneEmployee(employeeId));
                request.getRequestDispatcher(JSP_DETAIL_PAGE).forward(request, response);
            }
            else if (request.getParameter("cancel") != null)
            {
                request.setAttribute("empList", dba.getEmployees());
                request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
            }

            else if (request.getParameter("delete") != null)
            {
                if (isAdmin == false) request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
                {
                    request.setAttribute("empList", dba.getEmployees());
                    request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
                }
                myEmployee = new Employee();
                myEmployee.setId(Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID)));
                dba.deleteEmployee(myEmployee);
                request.setAttribute("empList", dba.getEmployees());
                request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
            }
            else if (request.getParameter("update") != null)
            {
                if (isAdmin == false) request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
                {
                    request.setAttribute("empList", dba.getEmployees());
                    request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
                }
                myEmployee = new Employee();
                myEmployee.setId(Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID)));
                myEmployee.setName(request.getParameter(FRM_EMPLOYEE_NAME));
                myEmployee.setFirstname(request.getParameter(FRM_EMPLOYEE_FIRSTNAME));
                myEmployee.setHomePhone(request.getParameter(FRM_EMPLOYEE_TELHOME));
                myEmployee.setMobilePhone(request.getParameter(FRM_EMPLOYEE_TELMOB));
                myEmployee.setProPhone(request.getParameter(FRM_EMPLOYEE_TELPRO));
                myEmployee.setAddress(request.getParameter(FRM_EMPLOYEE_ADDRESS));
                myEmployee.setPostalCode(request.getParameter(FRM_EMPLOYEE_POSTALCODE));
                myEmployee.setCity(request.getParameter(FRM_EMPLOYEE_CITY));
                myEmployee.setMail(request.getParameter(FRM_EMPLOYEE_EMAIL));
                dba.updateEmployee(myEmployee);
                request.setAttribute("empList", dba.getEmployees());
                request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
            }
            else if (request.getParameter("logout") != null)
            {
                request.getSession().invalidate();
                request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
            }
        }
        else
        {
            request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
        }
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
