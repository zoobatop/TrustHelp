package br.com.TrustHelp.Service;

import br.com.TrustHelp.Model.User;
import br.com.TrustHelp.Repository.UserRepository;

public class UserService {

    public User AddUser(){
        UserRepository  userRepository = new UserRepository();


        User result = userRepository.AddUser();

        return result;
    }
}
