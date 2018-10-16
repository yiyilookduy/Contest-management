package duypn.controllers.contest;

import duypn.classes.ActionHelper;
import duypn.classes.ApplicationContants;
import duypn.classes.converters.DtoConverter;
import duypn.daos.ContestDAO;
import duypn.dtos.ContestDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateContestController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String urlResult = null;
        try {
            ContestDTO contest = DtoConverter.getContestDTO(request);

            boolean check = ContestDAO.Instance().create(contest);
            if(!check){
                urlResult = ActionHelper.Match("Error");
                request.setAttribute("ERROR", "Update failed");
            } else urlResult = ActionHelper.Match("LoadContest");

        } catch (Exception e) {
            e.printStackTrace();
            log(e.getMessage());
        } finally {
            response.sendRedirect(urlResult);
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
