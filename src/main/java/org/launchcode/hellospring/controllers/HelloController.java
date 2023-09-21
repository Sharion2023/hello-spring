package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //Handles request at path /hello
    //@GetMapping("hello")
    //@ResponseBody
    //public String hello() {
     //   return "Hello, Spring!";
   // }

    //with Request Mapping added above class, this now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode (takes query parameter called name with a given value, value used in response)

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + " !";
    }

    //lives at /hello/hello
    //Handles requests of the form /hello/LaunchCode (data part of the path, not query string)
    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + " !";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html" +
                "<body>" +
                "<form action = 'hello' method= 'post'>" + //submit request to \hello
                "<input type = 'text' name= name>" +
                "<input type= 'submit' value = 'Greet me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
