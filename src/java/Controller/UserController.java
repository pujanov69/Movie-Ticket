/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UserDao;
import Model.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class UserController extends HttpServlet {

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
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
       if(request.getParameter("action").equals("logout")){
           HttpSession s=request.getSession();
           s.removeAttribute("loginuser");
           response.sendRedirect("login.jsp");
       }
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

        if (request.getParameter("submit").equals("Signup")) {
            UserInfo user = new UserInfo();
            user.setUsername((String) request.getParameter("username"));
            user.setPassword((String) request.getParameter("password"));
            user.setName((String) request.getParameter("name"));
            user.setGender((String) request.getParameter("gender"));
            user.setAddress((String) request.getParameter("address"));
            user.setMobile((String) request.getParameter("mobile"));
            user.setEmail((String) request.getParameter("email"));

            UserDao userDao = new UserDao();
            userDao.signup(user);
            response.sendRedirect("finish.jsp");
        }

        if (request.getParameter("submit").equals("Login")) {
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            UserDao userDao = new UserDao();
             UserInfo user = userDao.SignIn(username, password);
            
             HttpSession session = request.getSession();
            
           session.setAttribute("loginuser", user);
           //session.removeAttribute("loginuser");
            if (user != null) {

                response.sendRedirect("insidelogin.jsp");
            } else {
                response.sendRedirect("errorlogin.jsp");
            }

        }
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
