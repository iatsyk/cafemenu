package tk.iatsyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.iatsyk.service.CafeService;

@Controller
@RequestMapping("/")
public class CafeController {

    @Autowired
    private CafeService appService;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(Model model) {
        model.addAttribute("invitation", appService.getProperties());
        return "hello";
    }
}
