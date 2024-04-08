package com.fiap.sprint.controller;

import com.fiap.sprint.model.Fornecedor;
import com.fiap.sprint.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @RequestMapping("/form")
    public String formFornecedor(Model model){
        Fornecedor fornecedor = new Fornecedor();
        model.addAttribute("fornecedor",fornecedor);
        return "form-fornecedor";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("fornecedor") Fornecedor fornecedor){
        fornecedorService.save(fornecedor);
        return "redirect:/fornecedor/lista";
    }

    @RequestMapping("/lista")
    public String processFornecdor(Model model){
        List fornecedores = fornecedorService.findAll();
        model.addAttribute("fornecedores",fornecedores);
        return "fornecedor-data";
    }

    @RequestMapping("/delete")
    public String deleteFornecedor(@RequestParam("fornecedorId") Long id){
        fornecedorService.deleteById(id);
        return "redirect:/fornecedor/lista";
    }


}
