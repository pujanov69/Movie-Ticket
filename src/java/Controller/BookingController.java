/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.FinalBookingDao;
import Dao.MoviesDao;
import Dao.ShowTimeDao;
import Model.FinalBookingEntity;
import Model.NowShowingEntity;
import Model.ShowTimesEntity;
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
public class BookingController extends HttpServlet {

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
            out.println("<title>Servlet BookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingController at " + request.getContextPath() + "</h1>");
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
        String mid = request.getParameter("mid");
        String username=request.getParameter("user");
        String movie_name=request.getParameter("movie_name");
       
        
        if(action.equals("show_booked_ticket")){
        FinalBookingDao fbd = new FinalBookingDao();
        ArrayList<FinalBookingEntity> final_booking_value = fbd.getFinalBooking();
        request.setAttribute("final_booking_value",final_booking_value);
        RequestDispatcher rd = request.getRequestDispatcher("View_Booked_Ticket.jsp");
        rd.forward(request, response);
        }
        
        
        else
        {
            
        MoviesDao acb = new MoviesDao();
        ArrayList<NowShowingEntity> ml = acb.getMovies(mid);
        ShowTimeDao s = new ShowTimeDao();
        ArrayList<ShowTimesEntity> st = s.getShowTimes();
      

        request.setAttribute("movie", ml);
        request.setAttribute("st", st);
        request.setAttribute("seatData", "");
        RequestDispatcher rd = request.getRequestDispatcher("Semi_Final_Booking.jsp");
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
         if (action.equals("finalbooking")) {
               String seatArray[] = null;
            
        String seatData=request.getParameter("seatData");
        if(seatData!=null)
        {
            seatArray= seatData.split(",");
        }
           
            FinalBookingEntity booking = new FinalBookingEntity();
            booking.setUser_name((String) request.getParameter("username"));
            booking.setMovie_choosen((String) request.getParameter("movie_choosen"));
            booking.setShowtime_choosen((String) request.getParameter("showtime_choosen"));
            booking.setDay_choosen((String) request.getParameter("day_choosen"));
            booking.setPayment((String) request.getParameter("payment"));
            booking.setGender((String) request.getParameter("gender"));
            booking.setAddress((String) request.getParameter("address"));
            booking.setEmail((String) request.getParameter("email"));
            
            FinalBookingDao fbd = new FinalBookingDao();
            fbd.booknow(booking,seatArray);
            request.setAttribute("booking", booking);
            
           
            RequestDispatcher rd = request.getRequestDispatcher("Booking_Success.jsp");
            rd.forward(request, response);
        }else if(action.equals("SemiFinal")){
        
            if(request.getParameter("Submit").equals("Submit")){
                String arrayData = request.getParameter("seatData");
                
        String mid = request.getParameter("nsmid");
        String showtime = request.getParameter("showtime");
        String day = request.getParameter("day");
        MoviesDao md = new MoviesDao();
        ArrayList<NowShowingEntity> ml = md.getMovies(mid);
        RequestDispatcher rd = request.getRequestDispatcher("Final_Book.jsp");
        
        if (day.equals("Saturday")) {
            request.setAttribute("price", "400");
        } 
        else {
            request.setAttribute("price", "300");
        }
        request.setAttribute("seatData", arrayData);
        request.setAttribute("showtime", showtime);
        request.setAttribute("day", day);
        request.setAttribute("movie", ml);
        rd.forward(request, response);
            }
            else
            {
                String mid = request.getParameter("nsmid");
                String showtime=request.getParameter("showtime");
                String day = request.getParameter("day");
                String movie_name=request.getParameter("movie_name");
                ShowTimeDao s = new ShowTimeDao();
                String seatData = s.getSeatData(movie_name,showtime,day);
                request.setAttribute("seatData", seatData);
                  MoviesDao acb = new MoviesDao();
        ArrayList<NowShowingEntity> ml = acb.getMovies(mid);
        
        ArrayList<ShowTimesEntity> st = s.getShowTimes();
        
        request.setAttribute("showtime", showtime);
        request.setAttribute("day", day);        
        request.setAttribute("movie", ml);
        request.setAttribute("st", st);
        RequestDispatcher rd = request.getRequestDispatcher("Semi_Final_Booking.jsp");
        rd.forward(request, response);
                
            }
        
    }
         
         else if(action.equals("Booking_Success")){
        
        String mid = request.getParameter("nsmid");
        String showtime = request.getParameter("showtime");
        String day = request.getParameter("day");
        MoviesDao md = new MoviesDao();
        ArrayList<NowShowingEntity> ml = md.getMovies(mid);
        RequestDispatcher rd = request.getRequestDispatcher("Final_Book.jsp");
        
        if (day.equals("Saturday")) {
            request.setAttribute("price", "400");
        } 
        else {
            request.setAttribute("price", "300");
        }
        request.setAttribute("showtime", showtime);
        request.setAttribute("day", day);
        request.setAttribute("movie", ml);
        rd.forward(request, response);
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
