package Controller;

import Connection.DBConnection;
import Dao.MoviesDao;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadHandler extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String name="";
        String movie_name="";
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
                    }
                    

                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
                
                
                MoviesDao moviesDao= new MoviesDao();
                moviesDao.AddNowShowingMovies(movie_name,name);
                
                

            } catch (Exception ex) {

                request.setAttribute("message", "File Upload Failed due to " + ex);

            }

        } else {

            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");

        }

        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

}
