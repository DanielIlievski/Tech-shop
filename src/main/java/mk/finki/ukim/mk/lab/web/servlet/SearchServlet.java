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
//@WebServlet(name = "SearchServlet", urlPatterns = "/search")
//public class SearchServlet extends HttpServlet {
//
//    private final BalloonService balloonService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public SearchServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
//        this.balloonService = balloonService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        String searchField = req.getParameter("search");
////        context.setVariable("list", this.balloonService.searchByNameOrDescription(searchField));
//        this.springTemplateEngine.process("listBalloons.html", context, resp.getWriter());
//    }
//}
