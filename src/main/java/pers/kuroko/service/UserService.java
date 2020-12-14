package pers.kuroko.service;

import pers.kuroko.entity.User;

public interface UserService {
    User selectUserByUsername(String uname);
    int addUser(User user);
}
