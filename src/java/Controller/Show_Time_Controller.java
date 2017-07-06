/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ShowTimeDao;
import Dao.UserDao;
import Model.ShowTimesEntity;
import Model.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class Show_Time_Controller extends HttpServlet {

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
            out.println("<title>Servlet Show_Time_Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Show_Time_Controller at " + request.getContextPath() + "</h1>");
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
         String action=request.getParameter("action");
         if(action.equals("show_showtime")){
              ShowTimeDao showtimedao=new ShowTimeDao();
        ArrayList<ShowTimesEntity> show_times_value = showtimedao.getShowTimes();
        request.setAttribute("show_times_value",show_times_value);
        
        RequestDispatcher rd = request.getRequestDispatcher("show_times.jsp");
        rd.forward(request, response);
         }
         else if(action.equals("d_or_E_st")){
             ShowTimeDao stdao = new ShowTimeDao();
        ArrayList<ShowTimesEntity> show_times_value = stdao.getShowTimes();
        request.setAttribute("show_times_value",show_times_value);
         RequestDispatcher rd = request.getRequestDispatcher("delete_or_edit_show_times.jsp");
        rd.forward(request, response);
             
         }
         
             else if(action.equals("edit_show_time")){
            int stid=Integer.parseInt(request.getParameter("stid"));
            ShowTimeDao std = new ShowTimeDao();
            ShowTimesEntity ste=std.edit_show_time(stid);
        request.setAttribute("show_time",ste);
         RequestDispatcher rd = request.getRequestDispatcher("edit_show_time.jsp");
        rd.forward(request, response);
            
        }
         
             else if(action.equals("delete_show_time")){
                  int stid=Integer.parseInt(request.getParameter("stid"));
            ShowTimeDao std = new ShowTimeDao();
            ShowTimesEntity ste=std.edit_show_time(stid);
        request.setAttribute("show_time",ste);
         RequestDispatcher rd = request.getRequestDispatcher("delete_show_time.jsp");
        rd.forward(request, response);
                 
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
        String action=request.getParameter("action");
       if(action.equals("add_show_time")){
            ShowTimesEntity showtime = new ShowTimesEntity();
            showtime.setMorning_show_time((String) request.getParameter("morning_show_time"));
            showtime.setAfternoon1_show_time((String) request.getParameter("afternoon1_show_time"));
            showtime.setAfternoon2_show_time((String) request.getParameter("afternoon2_show_time"));
            showtime.setNight1_show_time((String) request.getParameter("night1_show_time"));
            showtime.setNight2_show_time((String) request.getParameter("night2_show_time"));
            
            ShowTimeDao showtimeDao = new ShowTimeDao();
            showtimeDao.AddShowTime(showtime);
           
       }
        else if(action.equals("edit_show_time")){
             int stid=Integer.parseInt(request.getParameter("stid"));
             
            String mshow=request.getParameter("mshow");
            String afshow1=request.getParameter("afshow1");
            String afshow2=request.getParameter("afshow2");
            String nshow1=request.getParameter("nshow1");
            String nshow2=request.getParameter("nshow2");
            
            ShowTimeDao showtimeDao = new ShowTimeDao();
            showtimeDao.EditShowTime(mshow,afshow1,afshow2,nshow1,nshow2,stid);
            
        }
        else if(action.equals("delete_show_time")){
            int stid=Integer.parseInt(request.getParameter("stid"));
             ShowTimeDao showtimeDao = new ShowTimeDao();
             showtimeDao.delete_show_time(stid);
            
            
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
