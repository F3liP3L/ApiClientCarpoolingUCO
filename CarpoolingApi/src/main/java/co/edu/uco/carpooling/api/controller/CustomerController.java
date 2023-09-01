package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.UserDTO;
import co.edu.uco.carpooling.service.facade.user.RegisterUserUseCaseFacade;
import co.edu.uco.crosscutting.util.UtilText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carpooling/customer")
public class CustomerController {

    @Autowired
    private RegisterUserUseCaseFacade userUseCaseFacade;

    @GetMapping("/{message}")
    public String sayHello(@PathVariable String message) {
        return UtilText.getUtilText().getDefault(message, "Buenas ❤️");
        }

    @PostMapping("/create/{customer}")
    public void createCustomer(@RequestBody UserDTO userDTO) {
        userUseCaseFacade.execute(userDTO);
    }
}