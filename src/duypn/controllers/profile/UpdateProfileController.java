/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.controllers.profile;

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

import static duypn.classes.converters.StringConverter.*;


/**
 *
 * @author duypnse63523
 */
public class UpdateProfileController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            AccountDTO account = (AccountDTO)session.getAttribute("Account");
            
            request.setCharacterEncoding("UTF-8");

            UserDTO user = getUserInfo(account.getUsername(),request);
            
            boolean check = UserDAO.Instance().updateUserInfo(user);
            if(check) {
                request.setAttribute("UserInfo", user);
                request.setAttribute("ProvinceName", convert(request.getParameter("Province")));
                request.setAttribute("DistrictName", convert(request.getParameter("District")));
                request.setAttribute("WardName", convert(request.getParameter("Ward")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log(e.getMessage());
        } finally{
            request.getRequestDispatcher("Profile.jsp").forward(request, response);
        }
    }

    private UserDTO getUserInfo(String Username, HttpServletRequest request) throws Exception {

        String firstName = convert(request.getParameter("FirstName"));

        String lastName = convert(request.getParameter("LastName"));

        String type = convert(request.getParameter("Type"));

        String phone = request.getParameter("Phone");

        int totalEvent = Integer.parseInt(request.getParameter("TotalEvent"));

        String address = convert(request.getParameter("Address"));

        String province = convert(request.getParameter("Province"));

        String district = convert(request.getParameter("District"));

        String ward = convert(request.getParameter("Ward"));

        int provinceId = ProvinceDAO.Instance().getProvinceId(province);
        int districtId = DistrictDAO.Instance().getDistrictId(district);
        int wardId = WardDAO.Instance().getWardId(ward);

        return new UserDTO(Username, firstName, lastName, phone, address, type, provinceId, districtId, wardId, totalEvent);
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
