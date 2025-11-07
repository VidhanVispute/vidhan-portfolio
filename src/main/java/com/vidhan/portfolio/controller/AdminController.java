package com.vidhan.portfolio.controller;

import com.vidhan.portfolio.entity.Project;
import com.vidhan.portfolio.service.ContactService;
import com.vidhan.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ProjectService projectService;
    private final ContactService contactService;

    @GetMapping({"", "/"})  // ← FIXED: Accept /admin and /admin/
    public String dashboard(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("contacts", contactService.getAllContacts());
        return "admin/dashboard";
    }

    @GetMapping("/projects")
    public String manageProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "admin/projects";
    }

    @GetMapping("/projects/new")
    public String newProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "admin/project-form";
    }

    @GetMapping("/projects/edit/{id}")
    public String editProject(@PathVariable Long id, Model model) {
        projectService.getProjectById(id).ifPresent(p -> model.addAttribute("project", p));
        return "admin/project-form";
    }

    @PostMapping("/projects/save")
    public String saveProject(@ModelAttribute Project project, RedirectAttributes ra) {
        projectService.saveProject(project);
        ra.addFlashAttribute("success", "Project saved!");
        return "redirect:/admin/projects";
    }

    @GetMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable Long id, RedirectAttributes ra) {
        projectService.deleteProject(id);
        ra.addFlashAttribute("success", "Project deleted!");
        return "redirect:/admin/projects";
    }

    @GetMapping("/contacts")
    public String viewContacts(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "admin/contacts";
    }
}