package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("hello")
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
                "<select name = 'language' >"+
                    "<option value= 'english'>English</option>"+
                    "<option value= 'spanish'>Spanish</option>"+
                    "<option value= 'french'>French</option>"+
                    "<option value= 'german'>German</option>"+
                    "<option value= 'italian'>Italian</option>"+
                "</select>" +
                "<input type= 'submit' value = 'Greet me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if(name == null) {
            name = "World";
        }
        return createMessage(name , language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")){
            greeting = "Hello";
        } else if (l.equals("french")) {
            greeting = "Bonjour";
        } else if (l.equals("spanish")) {
            greeting = "Hola";
        } else if (l.equals("german")) {
            greeting = "Guten tag";
        } else if (l.equals("italian")) {
            greeting = "Ciao";
        }
        return greeting + "," + n;
    }

}
