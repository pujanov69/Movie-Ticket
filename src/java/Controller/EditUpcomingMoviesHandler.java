/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MoviesDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author dell
 */
public class EditUpcomingMoviesHandler extends HttpServlet {

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
            out.println("<title>Servlet EditUpcomingMoviesHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditUpcomingMoviesHandler at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
         String name="";
        String movie_name="";
        String umid ="";
        String UPLOAD_DIRECTORY = request.getServletContext().getRealPath("../..") + "/web/uploads";
        
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {

                    if (!item.isFormField()) {

                        name = new File(item.getName()).getName();

                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

                    }
                    else
                    {
                        String field= item.getFieldName();
                        if(field.equals("movie_name"))
                        {
                            movie_name=item.getString();
                           
                        }
                        if(field.equals("umid"))
                        {
                            umid=item.getString();
                        }
                    }
                    

                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
                
                
                MoviesDao moviesDao= new MoviesDao();
                moviesDao.EditUpcomingMovies(movie_name,name,(Integer.parseInt(umid)));
                
                

            } catch (Exception ex) {

                request.setAttribute("message", "File Upload Failed due to " + ex);

            }

        } else {

            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");

        }

        response.sendRedirect("Movies?action=d_or_E_ucm");
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
