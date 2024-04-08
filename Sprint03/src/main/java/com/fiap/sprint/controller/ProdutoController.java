package com.fiap.sprint.controller;



import com.fiap.sprint.model.Produto;
import com.fiap.sprint.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/form")
    public String formFornecedor(Model model){
        Produto produto = new Produto();
        model.addAttribute("produto",produto);
        return "form-produto";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("produto") Produto produto){
        produtoService.save(produto);
        return "redirect:/produto/lista";
    }

    @RequestMapping("/lista")
    public String processFornecdor(Model model){
        List produtos = produtoService.findAll();
        model.addAttribute("produtos",produtos);
        return "produto-data";
    }

    @RequestMapping("/delete")
    public String deleteFornecedor(@RequestParam("produtoId") Long id){
        produtoService.deleteById(id);
        return "redirect:/produto/lista";
    }
}
