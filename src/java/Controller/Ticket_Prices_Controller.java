/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.TicketDao;
import Model.TicketPricesEntity;
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
public class Ticket_Prices_Controller extends HttpServlet {

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
            out.println("<title>Servlet Ticket_Prices_Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ticket_Prices_Controller at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
       
        
        String action=request.getParameter("action");
        
          if(action.equals("d_or_E_tp")){
             TicketDao tdao = new TicketDao();
        ArrayList<TicketPricesEntity> ticket_price_value = tdao.getTicketPrice();
        request.setAttribute("ticket_price_value",ticket_price_value);
         RequestDispatcher rd = request.getRequestDispatcher("delete_or_edit_ticket_prices.jsp");
        rd.forward(request, response);
        
        }
        
        
            else if(action.equals("edit_ticket_prices")){
            int tpid=Integer.parseInt(request.getParameter("tpid"));
            TicketDao tdao = new TicketDao();
            TicketPricesEntity tp=tdao.edit_ticket_price(tpid);
        request.setAttribute("ticket_price",tp);
         RequestDispatcher rd = request.getRequestDispatcher("edit_ticket_price.jsp");
        rd.forward(request, response);
            
        }
                 
                       else if(action.equals("delete_ticket_prices")){
            int tpid=Integer.parseInt(request.getParameter("tpid"));
            TicketDao tdao = new TicketDao();
            TicketPricesEntity tp=tdao.edit_ticket_price(tpid);
        request.setAttribute("ticket_price",tp);
         RequestDispatcher rd = request.getRequestDispatcher("delete_ticket_price.jsp");
        rd.forward(request, response);
            
        }
          
                 else if(action.equals("show_ticket_price")){
                      TicketDao ticketdao=new TicketDao();
        ArrayList<TicketPricesEntity> tikcet_prices_value = ticketdao.getTicketPrice();
        request.setAttribute("tikcet_prices_value",tikcet_prices_value);
        
        RequestDispatcher rd = request.getRequestDispatcher("ticketprices.jsp");
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
       // processRequest(request, response);
       String action=request.getParameter("action");
       if(action.equals("add_ticket_prices")){
            TicketPricesEntity ticketprice = new TicketPricesEntity();
            ticketprice.setDay((String) request.getParameter("day"));
            ticketprice.setPrice((String) request.getParameter("price"));
            
            
            TicketDao ticketDao = new TicketDao();
            ticketDao.AddTicketPrice(ticketprice);
           
       }
      
            
            
       else if(action.equals("edit_ticket_prices")){
                int tpid=Integer.parseInt(request.getParameter("tpid"));
                String day=request.getParameter("day");
                String price=request.getParameter("price");
            TicketDao tdao = new TicketDao();
            tdao.EditTicketPrice(day,price,tpid);
       
            }
            
       else if(action.equals("delete_ticket_prices")){
                int tpid=Integer.parseInt(request.getParameter("tpid"));
                String day=request.getParameter("day");
                String price=request.getParameter("price");
            TicketDao tdao = new TicketDao();
            tdao.delete_ticket_prices(tpid);
                
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
