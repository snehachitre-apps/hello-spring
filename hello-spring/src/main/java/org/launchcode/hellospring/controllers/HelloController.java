package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }
    //lives at /hello
    //handles requests fo the form /hello?name=LaunchCode
    @RequestMapping(value="hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting",theGreeting);
        return "hello";

    }
    //hello/name
    //hamndles forms requests hello/LaunchCode
    @GetMapping("{name}")
    public String hellowithPathParam(@PathVariable String name, Model model){
//        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting","Hello, " +name + "!");
        return "hello";

    }
    //  /hello/form
    @GetMapping("form")
    public String helloForm(){
        String html="";

        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Sneha");
        names.add("Sooriya");
        model.addAttribute("names",names);
        return "hello-list";

    }

    // responds to post requests at "/goodbye"
//    @PostMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }


    // responds to get and post requests at "/hellogoodbye"
//    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
//    public String hellogoodbye() {
//        return "hllo good bye spring";
//    }


}
