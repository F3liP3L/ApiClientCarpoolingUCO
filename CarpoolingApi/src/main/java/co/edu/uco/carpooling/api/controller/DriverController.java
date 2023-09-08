package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.service.facade.driver.RegisterDriverUseCaseFacade;
import co.edu.uco.carpooling.service.usecase.driver.ListDriverUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/carpooling/driver")
public class DriverController {

    @Autowired
    private RegisterDriverUseCaseFacade registerDriverUseCaseFacade;
    @Autowired
    private ListDriverUseCase listDriverUseCase;

    @GetMapping("/get")
    List<DriverDTO> getAllDriver() {
        return listDriverUseCase.execute(Optional.of(DriverDTO.createNewDriver()));
    }

    @PostMapping("/create/{driver}")
    void registerDriver(@PathVariable DriverDTO driver) {
        registerDriverUseCaseFacade.execute(driver);
    }
}
