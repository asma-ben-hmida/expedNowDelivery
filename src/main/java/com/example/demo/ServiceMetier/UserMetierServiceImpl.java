package com.example.demo.ServiceMetier;


import java.util.List;
import java.util.Optional;

import java.lang.RuntimeException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;
import com.example.demo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;


import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UserMetierServiceImpl  implements UserMetierService{


private final UserRepository userRepository ;
private final PasswordEncoder passwordEncoder;

public UserMetierServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    

}

public User saveUser(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
    
}

public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("user avec ID " + id + " non trouvé"));

}

public List<User> getAllUserByRole(){
    return userRepository.findByRoleNot(UserRole.SUPER_ADMIN);
   }

   public List<User>getAllLivreur(){

    return userRepository.findAllByRoleIn(List.of(UserRole.LIVREUR_PERMANENT,UserRole.LIVREUR_OCCASIONNEL));
   }

public void desactiveUser(Long id){

    Optional <User> userOpt = userRepository.findById(id);
    if (userOpt.isPresent()){
        User user =  userOpt.get();
        user.setActive(false); 
        userRepository.save(user);
    } else {
        throw new RuntimeException("user not found");
    }


}
public void activateUser(Long id) {

    User user = getUserById(id);
    user.setActive(true); // Réactivation
    userRepository.save(user);
}

 public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + id));

        // Mise à jour des champs
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setPassword(updatedUser.getPassword()); // encoder si nécessaire
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setActive(updatedUser.isActive());

        return userRepository.save(existingUser);
    }


/**
 * @return the userRepository
 */
public UserRepository getUserRepository() {
    return userRepository;
}

/**
 * @return the passwordEncoder
 */
public PasswordEncoder getPasswordEncoder() {
    return passwordEncoder;
}







}