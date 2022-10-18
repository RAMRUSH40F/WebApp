package logic;

import Cart.Cart;
import Cart.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Получаем продукт из Http запроса
        Product product = this.createProduct(request);


        // Здесь начинаем разбирать Session и Корзину
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");


        // Достаем из сессии корзину, если ее нет.
        if (cart == null){
            Cart new_cart = new Cart();
            new_cart.add(product.getName(), product);
            session.setAttribute("cart",new_cart);
        } else{
            cart.add(product.getName(), product);
            session.setAttribute("cart", cart);
        }


        //Заполнение и отправление формы html
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>Welcome to servlet cart</h2>");
            writer.println("<h2>Your cart contains "+cart.getQuontity() +" unit(s). The sum is "+cart.getSum()+"</h2>");
            writer.println("<h3>"+cart.printToHtml()+"</h3>");

        } finally {
            writer.close();
        }


    }

    private Product createProduct(HttpServletRequest request)
    {
        String name = Objects.requireNonNull(request.getParameter("name"));
        Integer price = Integer.parseInt(request.getParameter("price"));
        String origin = request.getParameter("origin");

        Product item = new Product();
        item.setPrice(price);
        item.setName(name);
        item.setOrigin(origin);
        return item;
    }


}

