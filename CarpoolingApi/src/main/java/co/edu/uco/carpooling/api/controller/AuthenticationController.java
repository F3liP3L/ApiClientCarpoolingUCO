package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.service.model.JwtRequest;
import co.edu.uco.carpooling.service.model.JwtResponse;
import co.edu.uco.carpooling.service.port.jwt.PortAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carpooling/auth")
public class AuthenticationController {
    @Autowired
    private PortAuthentication authenticate;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(authenticate.SignIn(request));
    }


}
