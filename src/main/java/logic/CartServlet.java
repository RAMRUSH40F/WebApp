package logic;

import Cart.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // Здесь начинаем разбирать Session и Корзину
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        String name = request.getParameter("name");
        Integer quontity = Integer.parseInt(request.getParameter("quontity"));

        if (cart == null){
            Cart init_cart = new Cart();
            init_cart.setName(name);
            init_cart.setQuontity(quontity);
            session.setAttribute("cart",init_cart);
        }




        //Заполнение и отправление формы html
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>Welcome to servlet cart</h2>");
            writer.println("<h2>Your cart:"+cart.getName()+" "+cart.getQuontity()+"units "+"</h2>");

        } finally {
            writer.close();
        }


    }



}

