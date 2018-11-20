package com.example.toystory.Controller;

import com.example.toystory.Component.Toy;
import com.example.toystory.Repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String dodaj(Toy toy){
        toyRep.add(toy);
        return "redirect:/";
    }
    @PostMapping("/skasuj")
    public String skasuj(@RequestParam String name){
        Toy findToy = toyRep.findByName(name);
        toyRep.remove(findToy);
        return "redirect:/";
    }
}
