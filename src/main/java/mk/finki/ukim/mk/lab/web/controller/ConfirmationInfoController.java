package mk.finki.ukim.mk.lab.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ConfirmationInfo")
public class ConfirmationInfoController {

    @GetMapping
    public String show(HttpServletRequest req, Model model) {
        model.addAttribute("ip", req.getRemoteAddr());
        model.addAttribute("browser", req.getHeader("User-Agent"));
        model.addAttribute("bodyContent", "confirmationInfo");
        return "master-template";
    }

    @PostMapping
    public String invalidate(HttpServletRequest req) {
        req.getSession().invalidate();
        return "redirect:/balloons";
    }
}
