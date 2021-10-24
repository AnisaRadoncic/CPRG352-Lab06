
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    private ArrayList<String> itemList = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
       
        if(action != null) {   
            if(action.equals("Logout")){
            session.invalidate(); 
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        
        if(action.equals("register")){
            String username = request.getParameter("username");
            session.setAttribute("userName", username);
        }
        
        if(action.equals("add")){
            String item = request.getParameter("itemEntered");
            itemList.add(item);
            session.setAttribute("items", itemList);
        }
       
        if(action.equals("delete")){
            String item = request.getParameter("itemName");
            itemList.remove(item);
            session.setAttribute("items", itemList);
        }
       
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
    }
    
}
