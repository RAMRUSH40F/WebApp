package logic;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookies extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cookie[] cookies = request.getCookies();

        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        for (Cookie cookie: cookies)
        {
            pw.println("<h1>"+cookie.getName()+" : "+cookie.getValue()+"</h1>");
        }

        pw.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }
}
