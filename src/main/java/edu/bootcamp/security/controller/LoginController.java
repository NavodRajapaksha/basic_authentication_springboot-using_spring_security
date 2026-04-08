package edu.bootcamp.security.controller;

import edu.bootcamp.security.model.UserModel;
import edu.bootcamp.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class LoginController {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserModel userModel){
        ResponseEntity  responseEntity = null;

        try{
            String hashPassword = passwordEncoder.encode(userModel.getPassword());
            userModel.setPassword(hashPassword);
            UserModel savesUser = userRepository.save(userModel);

            if (savesUser.getId()>0){
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given User Details are successfully Registered");
            }
        }catch (Exception e){
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured to"+ e.getMessage());
        }

        return responseEntity;
    }
}
