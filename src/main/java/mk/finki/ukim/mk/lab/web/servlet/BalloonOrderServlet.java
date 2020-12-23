//package mk.finki.ukim.mk.lab.web.servlet;
//
//
//import mk.finki.ukim.mk.lab.model.Order;
//import mk.finki.ukim.mk.lab.model.User;
//import mk.finki.ukim.mk.lab.service.OrderService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "BalloonOrderServlet", urlPatterns = "/BalloonOrder")
//public class BalloonOrderServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final OrderService orderService;
//
//    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.orderService = orderService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        this.springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        String balloonColor = (String) session.getAttribute("color");
//        String size = (String) session.getAttribute("size");
//        String username = req.getParameter("clientName");
//        String clientAddress = req.getParameter("clientAddress");
//        session.setAttribute("clientAddress", clientAddress);
//        session.setAttribute("username", username);
//
//        User user = new User();
//        user.setUsername(username);
//        this.orderService.placeOrder(balloonColor, size, user);
//
//        resp.sendRedirect("/ConfirmationInfo");
//    }
//}
