package com.example.OfflinePayment.Controller;

import com.example.OfflinePayment.ExceptionHandling.UserAlreadyEnrolledException;
import com.example.OfflinePayment.ExceptionHandling.UserNotFoundException;
import com.example.OfflinePayment.ServiceImpl.UserServiceImpl;
import com.example.OfflinePayment.Services.AuthenticationRequest;
import com.example.OfflinePayment.Services.AuthenticationResponse;
import com.example.OfflinePayment.Services.AuthenticationService;
import com.example.OfflinePayment.Services.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationService service;



    @PostMapping("/enroll")
    public ResponseEntity<String> enrollForOfflinePayment(@RequestParam(name="userId") Long userId) {
        try {
            userService.enrollForOfflinePayment(userId);
            return ResponseEntity.ok("Enrolled for offline payment successfully.");
        } catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (UserAlreadyEnrolledException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already enrolled.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
