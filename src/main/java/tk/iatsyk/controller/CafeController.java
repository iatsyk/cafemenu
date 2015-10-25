package tk.iatsyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.iatsyk.entities.businessentities.Cafe;
import tk.iatsyk.entities.representationobjects.CafeRO;
import tk.iatsyk.handler.CafeHandler;

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
    @ResponseBody
    Long save(Model model) {
        Cafe cafe = new Cafe();
        cafe.setDescription("desc");
        cafe.setName("name");
        cafe.setLatitude(46.5);
        cafe.setLongitude(30.25);
        cafe.setAddress("Vinnytsia");
        Long cafeId = cafeHandler.save(cafe);
        return cafeId;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cafes")
    public
    @ResponseBody
    List<CafeRO> getAllCafes() {
        return cafeHandler.getAllCafes();
    }

}
