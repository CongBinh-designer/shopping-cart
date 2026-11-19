package cart;

import java.io.*;

import business.LineItem;
import business.Product;
import business.Cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }

        if (action.equals("shop")) {
            url = "/index.jsp";
        }
        else if (action.equals("cart")) {
            String code = request.getParameter("code");
            String quantityString = request.getParameter("quantity");

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }

            int  quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) quantity = 1;
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }
            Product product = new Product();
            product.setCode(code);
            if (code.equals("1")) {
                product.setName("86 (the band) - True Life Songs and Pictures");
                product.setPrice(14.95);
            } else if (code.equals("2")) {
                product.setName("Paddlefoot - The first CD");
                product.setPrice(12.95);
            } else if (code.equals("3")) {
                product.setName("Paddlefoot - The Second CD");
                product.setPrice(14.95);
            } else if (code.equals("4")) {
                product.setName("Joe Rut - Genuine Wood Grained Finish");
                product.setPrice(14.95);
            }

            LineItem item = new LineItem(product, quantity);
            if (quantity > 0) {
                cart.addItem(item);
            } else if (quantity == 0) {
                cart.removeItemById(code);
            }

        session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }

        else if (action.equals("update")) {
            String code = request.getParameter("code");
            String quantityString = request.getParameter("quantity");
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            int quantity = 1;
            try {
                quantity = Integer.parseInt(quantityString);
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }
            Product product = new Product();
            product.setCode(code);
            LineItem item = new LineItem(product, quantity);
            if (quantity > 0) {
                cart.updateItem(item);
            } else {
                cart.removeItemById(code);
            }
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }
        else if (action.equals("checkout")) {
            url = "/checkout.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);


    }
}
