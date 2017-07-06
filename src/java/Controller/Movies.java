/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.DBConnection;
import Dao.MoviesDao;
import Model.NowShowingEntity;
import Model.TicketPricesEntity;
import Model.UpcomingMoviesEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class Movies extends HttpServlet {

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
            out.println("<title>Servlet Movies</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Movies at " + request.getContextPath() + "</h1>");
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
    
        System.out.println("Test");
        String action=request.getParameter("action");
        if(action.equals("nowshowing")){
            
        MoviesDao moviesDao = new MoviesDao();
        ArrayList<NowShowingEntity> now_showing_value = moviesDao.getNowShowingMovies();
        request.setAttribute("now_showing_value",now_showing_value);
        RequestDispatcher rd = request.getRequestDispatcher("now_showing_movies.jsp");
        rd.forward(request, response);
        }else if(action.equals("book")){
            MoviesDao moviesDao = new MoviesDao();
        ArrayList<NowShowingEntity> now_showing_value = moviesDao.getNowShowingMovies();
        request.setAttribute("now_showing_value",now_showing_value);
        RequestDispatcher rd = request.getRequestDispatcher("BookTicket.jsp");
        rd.forward(request, response);
            
        }
       
        else if(action.equals("upcoming")){
            MoviesDao moviesDao = new MoviesDao();
            ArrayList<UpcomingMoviesEntity> upcoming_value = moviesDao.getUpcomingMovies();
           request.setAttribute("upcoming_value",upcoming_value);
           RequestDispatcher rd = request.getRequestDispatcher("upcomingmovies.jsp");
           rd.forward(request, response); 
            
        }
        
        
        
        else if(action.equals("d_or_E_nsm")){
             MoviesDao moviesDao = new MoviesDao();
        ArrayList<NowShowingEntity> now_showing_value = moviesDao.getNowShowingMovies();
        request.setAttribute("now_showing_value",now_showing_value);
         RequestDispatcher rd = request.getRequestDispatcher("delete_or_edit_now_showing_movies.jsp");
        rd.forward(request, response);
        
        }
         else if(action.equals("d_or_E_ucm")){
             MoviesDao moviesDao = new MoviesDao();
        //ArrayList<NowShowingEntity> now_showing_value = moviesDao.getNowShowingMovies();
        ArrayList<UpcomingMoviesEntity> upcoming_value = moviesDao.getUpcomingMovies();
           request.setAttribute("upcoming_value",upcoming_value);
           RequestDispatcher rd = request.getRequestDispatcher("delete_or_edit_upcoming_movies.jsp");
           rd.forward(request, response); 
        
        }
        
        
        else if(action.equals("edit_movies")){
            int mid=Integer.parseInt(request.getParameter("mid"));
            MoviesDao md=new MoviesDao();
            NowShowingEntity m=md.edit_movie(mid);
        request.setAttribute("movie",m);
         RequestDispatcher rd = request.getRequestDispatcher("edit_nowshowing_movie.jsp");
        rd.forward(request, response);
            
        }
        
        else if(action.equals("delete_movie")){
            int mid=Integer.parseInt(request.getParameter("mid"));
            MoviesDao md=new MoviesDao();
            md.delete_movie(mid);
        
         RequestDispatcher rd = request.getRequestDispatcher("Delete_success_Movies.jsp");
        rd.forward(request, response);
        
        }
        
        else if(action.equals("edit_upcoming_movies")){
            int mid=Integer.parseInt(request.getParameter("mid"));
            MoviesDao md=new MoviesDao();
            UpcomingMoviesEntity m=md.edit_upcoming_movie(mid);
        request.setAttribute("movie",m);
         RequestDispatcher rd = request.getRequestDispatcher("edit_upcoming_movie.jsp");
        rd.forward(request, response);
            
        }
        
         else if(action.equals("delete_upcoming_movie")){
            int mid=Integer.parseInt(request.getParameter("mid"));
            MoviesDao md=new MoviesDao();
            md.delete_upcoming_movie(mid);
        
         RequestDispatcher rd = request.getRequestDispatcher("Delete_success_Movies.jsp");
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
        //processRequest(request, response);
        
       
        
        
        
        
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
