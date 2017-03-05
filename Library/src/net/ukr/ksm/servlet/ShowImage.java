package net.ukr.ksm.servlet;

import net.ukr.ksm.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class ShowImage extends HttpServlet {

    int i = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");

        //response.setContentType("image/png");

        OutputStream outputStream = response.getOutputStream();
        try {
            int index = Integer.valueOf(request.getParameter("index"));

            ArrayList<Book> list = (ArrayList<Book>)request.getSession(false).getAttribute("currentBookList");
            Book book = list.get(index);
            response.setContentLength(book.getImage().length);
            outputStream.write(book.getImage());
        }finally {
            outputStream.close();
        }

    }

}
