package Servlet;

import Bean.BeanInserimentoCSV;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    private File file;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean b=false;
        boolean isMultipart;
        String filePath;
        int maxFileSize = 500000*1024;
        int maxMemSize = 50*1024;
       // filePath=getServletContext().getInitParameter("file_upload");
        filePath = request.getServletContext().getRealPath("");

        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!isMultipart) {
            //out.print("file not uploded");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxFileSize);
        factory.setRepository(new File("home/tmp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);
        try{
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            while (i.hasNext()){
                FileItem fi = (FileItem) i.next();
                if(!fi.isFormField()){
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    if(fileName.lastIndexOf("/")>= 0){
                        file = new File(filePath+fileName.substring(fileName.lastIndexOf("/")));

                    }else {
                        file = new File(filePath+fileName.substring(fileName.lastIndexOf("/")+1));
                    }
                    fi.write(file);

                    BeanInserimentoCSV inserimentoCSV = new BeanInserimentoCSV();
                    b=inserimentoCSV.inserisciDatiCSV(fileName,filePath);
                    //out.println("file Uploaded : "+fileName);
                }
            }
        } catch (Exception ex) {
            System.out.println("Errore: " + ex.getMessage());
        } finally {

            if(b) {
                request.getRequestDispatcher("/ResultsPagesJSP/resultCorrectInsert.jsp").forward(request, response);
                //out.close();
            }else {
                request.getRequestDispatcher("/ResultsPagesJSP/resultErrorCSVFormat.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
