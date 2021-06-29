package project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Shopping")
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AccountBean acc;
    private Map<Item, Integer> inventory = new HashMap<>();

    private Item parseFromString(String str){
        Item item = new Item(str, str, null);
        String[] parts = str.split("-");
        item.setIID(parts[0].trim());
        item.setProduct(parts[1].trim());
        item.setPrice(Double.valueOf(parts[2].trim()));
        return item;
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //-------------------Handle Account Request----------------------
        if (this.acc == null){
            acc = new AccountBean();
            acc.setName(request.getParameter("username"));
            acc.setPassword(request.getParameter("password"));
        }
        System.out.println(acc);
        request.setAttribute("acc", acc);
        
        //-------------------Handle Item Request----------------------
        String itemStr = request.getParameter("item");
        String quantity = request.getParameter("quantity");

        if (itemStr != null && quantity != null){
            Item item = parseFromString(itemStr);
            Integer quantityInt = Integer.valueOf(quantity);

            inventory.put(item, inventory.getOrDefault(item, 0) + quantityInt);
        }
        request.setAttribute("inventory", inventory);
        
        //-------------------Handle Item Delete----------------------
        String deleteItemStr = request.getParameter("productDelete");
        System.out.println("ItemStrDelete: "+ deleteItemStr);
        Item deleteItem = null;
        if (deleteItemStr != null) {
            for (Item item : inventory.keySet()){
                if (item.getProduct().equals(deleteItemStr)){
                    deleteItem = item;
                    break;
                }
            }
            if (deleteItem != null){
                inventory.remove(deleteItem);
            }
        }
        System.out.println("Item Deleted: " + deleteItem);
        request.setAttribute("inventory", inventory);

        //-----------------------ForwardToProduct---------------------
        if (request.getParameter("checkout") == null && request.getParameter("delete") == null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Category.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CheckOut.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
