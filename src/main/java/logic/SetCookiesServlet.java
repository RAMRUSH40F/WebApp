package logic;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetCookiesServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cookie cookie1 = new Cookie("someId","123");
        // Сколько будет храниться на браузере клиента
        cookie1.setMaxAge(24*60);

        Cookie cookie2 = new Cookie("someName","123");
        // Сколько будет храниться на браузере клиента
        cookie1.setMaxAge(24*60*600);

        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }
}
