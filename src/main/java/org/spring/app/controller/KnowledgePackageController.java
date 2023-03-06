package org.spring.app.controller;

import jakarta.validation.Valid;
import org.spring.app.dto.KnowledgePackageDto;
import org.spring.app.model.KnowledgePackage;
import org.spring.app.service.KnowledgePackageService;
import org.spring.app.utility.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackageController {
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageController(KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageService = knowledgePackageService;
    }

    @GetMapping
    public String index() {
        return "kpacs/index";
    }

    @GetMapping( "/table")
    @ResponseBody
    public List<KnowledgePackageDto> table() {
        return Mapper.mapList(
                knowledgePackageService.findAll(),
                KnowledgePackageDto.class);
    }

    @PostMapping("/save")
    public String save(@Valid KnowledgePackageDto knowledgePackage,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("knowledgePackage", knowledgePackage);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "kpacs/new";
        }
        knowledgePackageService.save(
                Mapper.map(knowledgePackage, KnowledgePackage.class));
        return "redirect:/kpacs";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        knowledgePackageService.deleteById(id);
        return "redirect:/kpacs";
    }

    @GetMapping("/new")
    public String newKp() {
        return "kpacs/new";
    }
}
