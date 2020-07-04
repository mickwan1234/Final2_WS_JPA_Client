/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghianh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nghianh.clients.NghianhClient;
import nghianh.dtos.Registration;

/**
 *
 * @author Admin
 */
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");

            String search = request.getParameter("txtSearch");
            NghianhClient client = new NghianhClient();
            String action = request.getParameter("action");
            if (action.equals("GetALL")) {
//                List<Registration> result = client.findAll_XML(List.class);
//                for (Registration regis : result) {
//                    out.println("username: " + regis.getUsername() + "<br/>");
//                    out.println("fullname: " + regis.getFullname() + "<br/>");
//                    out.println("role: " + regis.getRole() + "<br/>");
//                }
            
            String s = client.findAll_XML(String.class);
                System.out.println("S= "+s);
            } else if (action.equals("FindByPK")) {
                Registration regis = client.find_XML(Registration.class, search);
                out.println("username: " + regis.getUsername() + "<br/>");
                out.println("fullname: " + regis.getFullname() + "<br/>");
                out.println("role: " + regis.getRole() + "<br/>");
            } else if (action.equals("Insert")){
                Registration regis = new Registration();
                regis.setUsername("user1");
                regis.setPassword("user");
                regis.setFullname("user1");
                regis.setRole("user");
                client.create_XML(regis);
            }

            out.println("</body>");
            out.println("</html>");
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
