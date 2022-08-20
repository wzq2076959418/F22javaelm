package vip.epss.service;


import org.apache.ibatis.session.SqlSession;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;


import vip.epss.entity.vo.vo.MessageModel;
import vip.epss.utils.GetSqlSession;
import vip.epss.utils.StringUtil;



public class UserService{
//        用户登录


    public MessageModel userLogin(String userName, String password){

        MessageModel messageModel=new MessageModel();

        //回显数据
        User u=new User();
        u.setUsername(userName);
        u.setPassword(password);
        messageModel.setObject(u);

        //参数非空判断
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)){
            messageModel.setCode(0);
            messageModel.setMsg("用户姓名和密码不能为空！");
            //回显数据

            return messageModel;

        }



        SqlSession session= GetSqlSession.createSq1Session();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.queryUserByName(userName);


        //判断用户对象是否为空
        if (user == null){
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在！");

            return messageModel;

        }

        //比较密码
        if (!password.equals(user.getPassword())){
            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确！");

            return messageModel;
        }

        //登陆成功
        messageModel.setObject(user);
        return messageModel;
    }


}

