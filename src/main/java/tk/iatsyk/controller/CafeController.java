package tk.iatsyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.iatsyk.entities.Cafe;
import tk.iatsyk.handler.CafeHandler;

@Controller
@RequestMapping("/")
public class CafeController {

    @Autowired
    private CafeHandler cafeHandler;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(Model model) {
        model.addAttribute("invitation", cafeHandler.getProperties());
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/save")
    public String save(Model model) {
        Cafe cafe = new Cafe();
        cafe.setDescription("desc");
        cafe.setName("name");
        cafe.setLatitude(46.5);
        cafe.setLongitude(30.25);
        Long cafeId = cafeHandler.save(cafe);
        model.addAttribute("invitation", cafeId);
        return "hello";
    }
}
