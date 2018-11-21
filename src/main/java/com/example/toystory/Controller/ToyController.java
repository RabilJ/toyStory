package com.example.toystory.Controller;

import com.example.toystory.Component.Toy;
import com.example.toystory.Repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ToyController {
    private ToyRepository toyRep;

    @Autowired
    public ToyController(ToyRepository toyRep) {
        this.toyRep = toyRep;
    }

    @GetMapping("/lista")
    public String lista(Model model){
        model.addAttribute("anList",toyRep.getToyList());
        model.addAttribute("toyToFilter",new Toy());
        return "list";
    }
    @GetMapping("/toy")
    public String toy(@RequestParam String name,Model model ){
        Toy findToy = toyRep.findByName(name);
        model.addAttribute("foundToy",findToy);
        return "toy";
    }
    @GetMapping("/nowaDoDodania")
    public String nowaDoDodania(Model model){
        model.addAttribute("newToyToAdd",new Toy());
        return "toyAddForm";
    }
    @GetMapping("/nowaDoSkasowania")
    public String nowaDoSkasowania(Model model){
        model.addAttribute("newToyToDelete",new Toy());
        return "toyDeleteForm";
    }
    @PostMapping("/dodaj")
    public String dodaj(Toy toy, Model model){
        toyRep.add(toy);
        model.addAttribute("anList",toyRep.getToyList());
        return "list";
    }
    @PostMapping("/skasuj")
    public String skasuj(@RequestParam String name, Model model){
        Toy findToy = toyRep.findByName(name);
        toyRep.remove(findToy);
        model.addAttribute("anList",toyRep.getToyList());
        return "list";
    }
    @PostMapping("/filter")
    public String filter(@RequestParam String word, Model model){
        model.addAttribute("anList",toyRep.filter(word));
        return "list";
    }
    @GetMapping("/powrot")
    public String powrot(){
        return "redirect:/";
    }
}
