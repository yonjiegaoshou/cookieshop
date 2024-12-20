package servlet;

import service.GoodsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private final GoodsService gService=new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("=== IndexServlet == before"  + LocalDateTime.now());
    	System.out.println("  ");
    	List<Map<String,Object>> ScrollGood=gService.getScrollGood();
        request.setAttribute("scroll",ScrollGood);

        List<Map<String,Object>> newList=gService.getGoodsList(3);
        request.setAttribute("newList", newList);

        List<Map<String,Object>> hotList=gService.getGoodsList(2);
        request.setAttribute("hotList", hotList);

        //response.sendRedirect("index.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
        
        System.out.println("=== IndexServlet == after"  + LocalDateTime.now());
    	System.out.println("  ");

    }
}
