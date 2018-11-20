package com.example.toystory.Controller;

import com.example.toystory.Service.VisitCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    private VisitCounter counter;

    @Autowired
    public HomeController(VisitCounter counter) {
        this.counter = counter;
    }

    @GetMapping("/")
    public String home(Model model, HttpServletResponse response, @CookieValue(required = false)String lastVisits){
        if (lastVisits!=null)
            System.out.println(lastVisits);
        Cookie cookie = new Cookie("lastVisit", LocalDateTime.now().toString());
        cookie.setMaxAge(300);
        response.addCookie(cookie);
        int visits = counter.incrementAndGet();
        model.addAttribute("visits",visits);
        return "index";
    }
}
