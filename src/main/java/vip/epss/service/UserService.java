package vip.epss.service;

import org.apache.ibatis.annotations.Param;
import vip.epss.domain.User;
import vip.epss.domain.UserExample;

import java.util.List;

public interface UserService {

    int saveUser(User user);

    User getUserByIdByPass(String userId,String password);

    User getUserById(String userId);

}

