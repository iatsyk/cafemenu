package tk.iatsyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.iatsyk.entities.Cafe;
import tk.iatsyk.handler.CafeHandler;

import javax.xml.stream.Location;
import java.util.List;

@RestController
@RequestMapping("/services")
public class CafeController {

    @Autowired
    private CafeHandler cafeHandler;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public
    @ModelAttribute
    void hello(Model model) {
        model.addAttribute("invitation", cafeHandler.getProperties());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/save")
    public
    @ModelAttribute
    void save(Model model) {
        Cafe cafe = new Cafe();
        cafe.setDescription("desc");
        cafe.setName("name");
        cafe.setLatitude(46.5);
        cafe.setLongitude(30.25);
        cafe.setAddress("Vinnytsia");
        Long cafeId = cafeHandler.save(cafe);
        model.addAttribute("invitation", cafeId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cafes")
    public @ResponseBody
    List<Cafe> getAllCafes() {
        return cafeHandler.getAllCafes();
    }

}
