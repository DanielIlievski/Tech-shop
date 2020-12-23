package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {

//    private final AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//

    @GetMapping
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "login";
    }

//    @PostMapping
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpServletRequest request){
//        try{
//            User user = this.authenticationService.login(username, password);
//            request.getSession().setAttribute("user", user);
//            return "redirect:/balloons";
//        } catch(UserNotFoundException ex){
//            return "redirect:/login?error="+ex.getMessage();
//        }
//    }

}