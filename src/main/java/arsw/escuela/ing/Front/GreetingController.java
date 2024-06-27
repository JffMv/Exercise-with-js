package arsw.escuela.ing.Front;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("message", "Hello, " + name + "!");
        return "result";
    }

    @RequestMapping(
            value= "/hellopost",
            method = RequestMethod.POST,
            produces = "aplication/json"
    )
    public String hellopost(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model){
        return String.format("Hello %s!", name);
    }
}





