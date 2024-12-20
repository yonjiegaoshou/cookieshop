package filter;

import model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(filterName = "AdminFilter",urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    	
    	System.out.println("=== AdminFilter == "  + LocalDateTime.now());
    	System.out.println(" ");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse requestp = (HttpServletResponse)resp;
        User u = (User) request.getSession().getAttribute("user");
        
        System.out.println("=== AdminFilter = user = "  + request.getSession().getAttribute("user"));
    	System.out.println(" ");
    	
    	System.out.println("=== AdminFilter = u = "  + u);
     	System.out.println(" ");
        
        if(u==null || !u.isIsadmin()) {
            requestp.sendRedirect("../index.jsp");
        }else {
            // pass the request along the filter chain
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
