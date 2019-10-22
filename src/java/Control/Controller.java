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
import se.m1.User;
import se.m1.model.DBAction;
import static se.m1.Constants.*;
import se.m1.Employee;

/**
 *  ceci est un test
 * test2
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
        
        String action = request.getParameter("action");
        
        if(request.getParameter("connexion") != null)
        {
            //Data entered by the user
            userInput = new User();
            userInput.setLogin(request.getParameter(FRM_LOGIN_FIELD));
            userInput.setPassword(request.getParameter(FRM_PWD_FIELD));

            if (dba.checkCredentials(userInput)) {
                request.setAttribute("empList", dba.getEmployees());
                request.getRequestDispatcher(JSP_WELCOME_PAGE).forward(request, response);
            } else {
                request.setAttribute("errKey", ERR_MESSAGE);
                request.getRequestDispatcher(JSP_HOME_PAGE).forward(request, response);
            }
        }
        else if (request.getParameter("add") != null)
        {
            request.getRequestDispatcher(JSP_ADD_PAGE).forward(request, response);
        }
        else if (request.getParameter("addbutton") != null)
        {
            myEmployee = new Employee();
            myEmployee.setName(FRM_EMPLOYEE_NAME);
            myEmployee.setFirstname(FRM_EMPLOYEE_FIRSTNAME);
            myEmployee.setHomePhone(FRM_EMPLOYEE_TELHOME);
            myEmployee.setMobilePhone(FRM_EMPLOYEE_TELMOB);
            myEmployee.setProPhone(FRM_EMPLOYEE_TELPRO);
            myEmployee.setAddress(FRM_EMPLOYEE_ADRESS);
            myEmployee.setPostalCode(FRM_EMPLOYEE_POSTALCODE);
            myEmployee.setCity(FRM_EMPLOYEE_CITY);
            myEmployee.setMail(FRM_EMPLOYEE_EMAIL);
            
            dba.AddEmployee(myEmployee);
            PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>"); 
            
                    
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