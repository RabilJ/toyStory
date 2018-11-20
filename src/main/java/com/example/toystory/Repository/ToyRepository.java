package com.example.toystory.Repository;

import com.example.toystory.Component.Toy;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ToyRepository {

    private List<Toy>toyList = new ArrayList<>();

    public List<Toy> getToyList() {
        return toyList;
    }

    public ToyRepository() {
        toyList.add(new Toy("Chudy","Lego","https://www.partybox.pl/zasoby/images/middle/dekoracja_kartonowa_chudy_toy_story_29600.jpg"));
        toyList.add(new Toy("Buzz","Bionicle","https://s.mamotoja.pl/media/cache/source/media/product/201105/414_01_4408.jpg"));
        toyList.add(new Toy("SpiderBaby","Bionicle","https://vignette.wikia.nocookie.net/pixar/images/8/8c/Babyface.jpg/revision/latest?cb=20111206021132"));
    }

    public void add(Toy toy){
        toyList.add(toy);
    }
    public  void remove(Toy toy){
        toyList.remove(toy);
    }
    public Toy findByName(String name){
        for (Toy toy : toyList) {
            if(toy.getName().equals(name))
                return toy;
        }
        return null;
    }
}
