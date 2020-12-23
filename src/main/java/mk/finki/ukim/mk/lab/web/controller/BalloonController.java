package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.enumerations.BalloonStatus;
import mk.finki.ukim.mk.lab.model.exception.BalloonAlreadyExists;
import mk.finki.ukim.mk.lab.model.exception.ManufacturerNotFoundException;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService,
                             ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error,
                                  @RequestParam(required = false) String searchTerm,
                                  @RequestParam(required = false) String searchByStatus,
                                  Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        if (searchTerm != null) {
            model.addAttribute("balloons", this.balloonService.searchByNameOrDescription(searchTerm));
        } else if (searchByStatus != null) {
            model.addAttribute("balloons", this.balloonService.findByStatus(BalloonStatus.valueOf(searchByStatus)));
        } else {
            model.addAttribute("balloons", this.balloonService.listAll());
        }
        model.addAttribute("bodyContent", "listBalloons");
        return "master-template";
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddNewBalloonPage(Model model) {
        model.addAttribute("balloon", new Balloon());
        model.addAttribute("statuses", this.balloonService.findAllStatuses());
        model.addAttribute("manufacturers", this.manufacturerService.findAll());
        model.addAttribute("bodyContent", "addBalloon");
        return "master-template";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        model.addAttribute("balloon", this.balloonService.findById(id));
        model.addAttribute("statuses", this.balloonService.findAllStatuses());
        model.addAttribute("manufacturers", this.manufacturerService.findAll());
        model.addAttribute("bodyContent", "addBalloon");
        return "master-template";
    }

    @PostMapping
    public String saveBalloon(Balloon balloon) {
        try {
            this.balloonService.save(balloon);
        } catch (BalloonAlreadyExists | ManufacturerNotFoundException ex) {
            return "redirect:/balloons?error=" + ex.getMessage();
        }
        return "redirect:/balloons";
    }

    @PostMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

//    @PostMapping
//    public String saveBalloon(@RequestParam Long id, @RequestParam String name, @RequestParam String description) {
//        return null;
//    }
//
//    @PutMapping("/{id}")
//    public String updateBalloon(@PathVariable Long id, Balloon balloon) {
//        return null;
//    }


}
