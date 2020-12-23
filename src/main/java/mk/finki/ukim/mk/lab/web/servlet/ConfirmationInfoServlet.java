//package mk.finki.ukim.mk.lab.web.servlet;
//
//
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "ConfirmationInfoServlet", urlPatterns = "/ConfirmationInfo")
//public class ConfirmationInfoServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("ip", req.getRemoteAddr());
//        context.setVariable("browser", req.getHeader("User-Agent"));
//        springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession().invalidate();
//        resp.sendRedirect("/");
//    }
//}
