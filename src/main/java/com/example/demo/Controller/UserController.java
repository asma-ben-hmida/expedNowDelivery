package com.example.demo.Controller;

import com.example.demo.ServiceApplicatif.UserServiceApp;
import com.example.demo.ModelDomain.UserRole;
import com.example.demo.ModelDTO.UserDTO;
import com.example.demo.ModelDomain.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.prepost.PreAuthorize;



@RestController
@RequestMapping("/")
public class UserController {

    private final UserServiceApp userServiceApplicatif;

        public UserController(UserServiceApp userServiceApplicatif){
        this.userServiceApplicatif = userServiceApplicatif;
        }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping("/admin")
    public  ResponseEntity<UserDTO> saveAdmin(@RequestBody UserDTO userDTO){
        
        userDTO.setRole(UserRole.ADMIN);
        
        UserDTO saved= userServiceApplicatif.saveUser(userDTO);
       
       return ResponseEntity.status(HttpStatus.CREATED).body(saved);


    }

    @PreAuthorize("hasRole('SUPER_ADMIN','ADMIN')")
    @PostMapping("/livreurpermemnant")
    public ResponseEntity<UserDTO> saveLivreurpermenant(@RequestBody UserDTO userDTO){

        userDTO.setRole(UserRole.LIVREUR_PERMANENT);

        UserDTO saved =userServiceApplicatif.saveUser(userDTO);
         
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
                        
    }


    @PostMapping("/livreuroccasionnel")

    public ResponseEntity<UserDTO> saveLivreuroccasionnel(@RequestBody UserDTO userDTO){

        userDTO.setRole(UserRole.LIVREUR_OCCASIONNEL);

        UserDTO saved =userServiceApplicatif.saveUser(userDTO);
         
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
                        
    }
     

    
    @PostMapping("/clientEntreprise")

    public ResponseEntity<UserDTO> saveClientEntreprise(@RequestBody UserDTO userDTO){

        userDTO.setRole(UserRole.CLIENT_ENTREPRiSE);

        UserDTO saved =userServiceApplicatif.saveUser(userDTO);
         
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
                        
    }
     

    @PostMapping("/clientProfessionnel")

    public ResponseEntity<UserDTO> saveLivreurProfessionnel(@RequestBody UserDTO userDTO){

        userDTO.setRole(UserRole.CLIENT_PROFESSIONNEL);

        UserDTO saved =userServiceApplicatif.saveUser(userDTO);
         
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
                        
    }
     


}
