package com.vidhan.portfolio.controller;

import com.vidhan.portfolio.entity.Skill;
import com.vidhan.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/skills")
@RequiredArgsConstructor
public class SkillAdminController {

    private final SkillService skillService;

    @GetMapping({"", "/"})  // Accept both
    public String list(Model model) {
        model.addAttribute("skills", skillService.getAllSkills());
        return "admin/skills";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("skill", new Skill());
        return "admin/skill-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Skill skill) {
        skillService.saveSkill(skill);
        return "redirect:/admin/skills";
    }
}