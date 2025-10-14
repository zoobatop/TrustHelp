package br.com.TrustHelp.Controller;

import br.com.TrustHelp.Repository.UserRepository;

public class UserController {

    public AddUser(){
        if(name == ""){
            return;
        }
        if(name == "i"){
            return;
        }
        UserRepository userRepository = new UserRepository();

        userRepository.AddUser();
    }
}
