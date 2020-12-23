package mk.finki.ukim.mk.lab.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//public class ColorFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String path = request.getServletPath();
//        if(!path.startsWith("/balloons") && !path.startsWith("/favicon.ico")) {
//            if(request.getParameter("color") == null && request.getSession().getAttribute("color") == null) {
//                HttpServletResponse response = (HttpServletResponse) servletResponse;
//                response.sendRedirect("/balloons?error=Error");
//                return;
//            }
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//
//}
