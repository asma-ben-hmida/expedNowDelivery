package com.example.demo.ServiceMetier;


import com.example.demo.ModelDTO.UserDTO;
import com.example.demo.ModelDomain.User;

import java.util.List;
import java.util.Optional;

public interface UserMetierService {


    User saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUserByRole();
    void desactiveUser(Long id);
    void activateUser(Long id) ;
    User updateUser(Long id, User updatedUser);
    List<User>  getLivreursdispos();
    Optional<User> getLivreurDispoEtProche(double latitudeDemande ,double longitudeDemande );


}