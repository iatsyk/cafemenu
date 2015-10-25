package tk.iatsyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.iatsyk.entities.representationobjects.DishRO;
import tk.iatsyk.handler.DishesHandler;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
@RestController
@RequestMapping("/services")
public class DishesController {

    @Autowired
    private DishesHandler dishesHandler;

    @RequestMapping(method = RequestMethod.GET, path = "/dishes")
    public
    @ResponseBody
    List<DishRO> findAllDishesByCafeId(@RequestParam Long cafeId) {
        return dishesHandler.findAllDishesByCafeId(cafeId);
    }

}
