package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }
    //lives at /hello
    //handles requests fo the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){

        return "Hello, "+ name + "!";

    }
    //hello/name
    //hamndles forms requests hello/LaunchCode
    @GetMapping("{name}")
    public String hellowithPathParam(@PathVariable String name){
        return "Hello, "+ name + "!";

    }
    //  /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello'>" + //submit request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
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
