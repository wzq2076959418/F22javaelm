package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.User;
import vip.epss.domain.UserExample;

public interface UserMapper {


    int deleteByExample(UserExample example);



    int insertSelective(User row);

    List<User> selectByExample(Integer example);

    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    int updateByExample(@Param("row") User row, @Param("example") UserExample example);




    int saveUser(User user);
    User getUserByIdByPass(String userId,String password);

    User getUserById(String userId);
}