//package mk.finki.ukim.mk.lab.web.servlet;
//
//import mk.finki.ukim.mk.lab.service.BalloonService;
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
//@WebServlet(name = "BalloonListSevlet", urlPatterns = "")
//public class BalloonListSevlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final BalloonService balloonService;
//
//    public BalloonListSevlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.balloonService = balloonService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("list", this.balloonService.listAll());
//        String error = req.getParameter("error");
//        if (error != null)
//            context.setVariable("error", error);
//        this.springTemplateEngine.process("listBalloons.html", context, resp.getWriter());
//    }
//}
