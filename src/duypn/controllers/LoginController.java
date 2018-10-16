/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.controllers;

import duypn.classes.ActionHelper;
import duypn.classes.ApplicationContants;
import duypn.daos.AccountDAO;
import duypn.dtos.AccountDTO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author duypnse63523
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = null;
        try {
            HttpSession session = request.getSession();
            String username = request.getParameter("email");
            String password = request.getParameter("password");

            // Case user not login
            if (session.getAttribute("Account") == null && username != null && password != null) {

                AccountDTO currentAccount = AccountDAO.Instance().Login(username, password);

                // Account not exited, invalid username or password
                if (currentAccount == null) {
                    url = ApplicationContants.ERROR;
                    request.setAttribute("ERROR", "Username or password is invalid");
                }
                url = getActionResult(currentAccount.getRole());
                session.setAttribute("Account", currentAccount);

            } else if (session.getAttribute("Account") != null) {
                AccountDTO currentAccount = (AccountDTO) session.getAttribute("Account");
                url = getActionResult(currentAccount.getRole());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log(e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }


    private String getActionResult(String role) {
        return ActionHelper.Match(role);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
