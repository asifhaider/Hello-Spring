package com.example.demoform;

import org.glassfish.jersey.internal.inject.Custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @Autowired
    CustomerRepo repo;
    @RequestMapping("/")
    public String welcome(){
        return "edureka";
    }
    @RequestMapping("/details")
    public String details(Customers customers){
        repo.save(customers);
        return "edureka";
    }
    @RequestMapping("/getdetails")
    public String getdetails(){
        return "ViewCustomers";
    }
    @PostMapping("/getdetails")
    public ModelAndView viewDetails(@RequestParam("cid") int cid){
        ModelAndView mv = new ModelAndView("retrieve");
        Customers customers = repo.findById(cid).orElse(null);
        mv.addObject(customers);
        return mv;
    }
}
