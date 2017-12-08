package kz.salta.ssdb.service;

import kz.salta.ssdb.model.User;



public interface UserService {

    void save(User user);

    User findByUsername(String username);
    
    User getCurrentUser();
}
