package co.edu.uco.carpooling.api.controller;

import co.edu.uco.crosscutting.util.UtilText;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carpooling")
public class TestController {

    @GetMapping("/{message}")
    public String sayHello(@PathVariable String message) {
        return UtilText.getUtilText().getDefault(message, "Buenas ❤️");
        }
    }
