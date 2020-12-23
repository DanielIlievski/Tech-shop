package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/BalloonOrder")
public class BalloonOrderController {

    private final OrderService service;
    private final UserService userService;

    public BalloonOrderController(OrderService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public String getOrder(Model model) {
        model.addAttribute("bodyContent", "deliveryInfo");
        return "master-template";
    }

    @PostMapping
    public String makeOrder(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        String balloonColor = (String) session.getAttribute("color");
        String size = (String) session.getAttribute("size");
        String clientAddress = req.getParameter("clientAddress");
        session.setAttribute("clientAddress", clientAddress);
        String username = req.getRemoteUser();
        session.setAttribute("username", username);
        User user = userService.findByUsername(username).orElse(new User(username, clientAddress));
        this.service.placeOrder(balloonColor, balloonColor, user);
        return "redirect:/ConfirmationInfo";

    }

}
