package com.vidhan.portfolio.controller;

import com.vidhan.portfolio.entity.Contact;
import com.vidhan.portfolio.service.ContactService;
import com.vidhan.portfolio.service.ProjectService;
import com.vidhan.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProjectService projectService;
    private final SkillService skillService;
    private final ContactService contactService;

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String logout) {
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("skills", skillService.getAllSkills());
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "index";
    }

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@ModelAttribute Contact contact, RedirectAttributes ra) {
        contactService.saveContact(contact);
        ra.addFlashAttribute("success", "Thank you! Your message has been sent.");
        return "redirect:/contact";
    }
}