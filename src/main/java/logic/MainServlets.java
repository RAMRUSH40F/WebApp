package logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlets extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Здесь начинаем разбирать Session
        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("count");


        if (count == null){
            session.setAttribute("count",1);
            count = 1;
        }
        else session.setAttribute("count",count+1);

        //Заполнение и отправление формы html
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>Welcome to servlets, "+name+" "+surname+"</h2>");
            writer.println("<h2>You visited this site, "+count+"times throughtout this session.</h2>");

            writer.println("<h2>Add ?name parameter to see your name!</h2>");
        } finally {
            writer.close();
        }


    }



}

