package mk.finki.ukim.mk.lab.web.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller
@RequestMapping("/selectBalloon")
public class SelectBalloonController {

    @GetMapping
    public String selectTheBalloon(HttpServletRequest req, Model model) {
        String color = req.getParameter("color");
        req.getSession().setAttribute("color", color);
        model.addAttribute("bodyContent", "selectBalloonSize");
        return "master-template";
    }

    @PostMapping
    public String selectSize(HttpServletRequest req, Model model) {
        String size = req.getParameter("size");
        req.getSession().setAttribute("size", size);
        return "redirect:/BalloonOrder";
    }
}
