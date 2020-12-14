package pers.kuroko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kuroko.dao.UserDao;
import pers.kuroko.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByUsername(String uname) {
        return userDao.selectUserByUsername(uname);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
}
