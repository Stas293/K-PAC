package org.spring.app.controller;

import jakarta.validation.Valid;
import org.spring.app.dto.KnowledgePackageDto;
import org.spring.app.dto.KnowledgePackageSetDto;
import org.spring.app.dto.NewKnowledgePackageSetDto;
import org.spring.app.model.KnowledgePackageSet;
import org.spring.app.service.KnowledgePackageService;
import org.spring.app.service.KnowledgePackageSetService;
import org.spring.app.utility.Mapper;
import org.spring.app.utility.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sets")
public class KnowledgePackageSetController {
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageSetController(KnowledgePackageSetService knowledgePackageSetService,
                                         KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageService = knowledgePackageService;
    }

    @GetMapping
    public String index() {
        return "sets/index";
    }

    @GetMapping("/table")
    @ResponseBody
    public List<KnowledgePackageSetDto> table() {
        return Mapper.mapList(
                knowledgePackageSetService.findAll(),
                KnowledgePackageSetDto.class);
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        String json = Parser.valueToTree(
                Mapper.mapList(
                        knowledgePackageSetService.findById(id)
                                .getKnowledgePackages(),
                        KnowledgePackageDto.class)
        );
        model.addAttribute("set", json);
        return "sets/get";
    }

    @GetMapping("/new")
    public String newSet(Model model) {
        model.addAttribute("knowledgePackages", Mapper.mapList(
                knowledgePackageService.findAll(),
                KnowledgePackageDto.class));
        return "sets/new";
    }

    @PostMapping("/save")
    public String save(@Valid NewKnowledgePackageSetDto knowledgePackageSet,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("knowledgePackages", knowledgePackageService.findAll());
            model.addAttribute("knowledgePackageSet", knowledgePackageSet);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "sets/new";
        }
        KnowledgePackageSet knowledgePackageSet1 = Mapper.map(knowledgePackageSet, KnowledgePackageSet.class);
        knowledgePackageSet1.setKnowledgePackages(
                knowledgePackageService.findAllById(
                        knowledgePackageSet.getKnowledgePackages()));
        knowledgePackageSetService.save(knowledgePackageSet1);
        return "redirect:/sets";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        knowledgePackageSetService.deleteById(id);
        return "redirect:/sets";
    }
}
