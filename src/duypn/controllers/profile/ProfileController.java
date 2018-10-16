/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.controllers.profile;

import duypn.classes.ApplicationContants;
import duypn.daos.DistrictDAO;
import duypn.daos.ProvinceDAO;
import duypn.daos.UserDAO;
import duypn.daos.WardDAO;
import duypn.dtos.AccountDTO;
import duypn.dtos.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duypnse63523
 */
public class ProfileController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String url = ApplicationContants.ERROR;
        try {
            HttpSession session = request.getSession();
            AccountDTO account = (AccountDTO)session.getAttribute("Account");
            UserDTO user = UserDAO.Instance().getUserInfo(account.getUsername());
            String provinceName = ProvinceDAO.Instance().GetProvinceName(user.getProvinceId());
            String districtName = DistrictDAO.Instance().getDistrictName(user.getDistrictId());
            String wardName = WardDAO.Instance().getWardName(user.getWardId());
            System.out.println(user.getFirstname()+" "+ account.getEmail());
            if(user != null)
            {
                url = ApplicationContants.PROFILE;
                request.setAttribute("UserInfo", user);
                request.setAttribute("ProvinceName", provinceName);
                request.setAttribute("DistrictName", districtName);
                request.setAttribute("WardName", wardName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log(e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
