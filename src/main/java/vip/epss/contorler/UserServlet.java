package vip.epss.contorler;

import com.fasterxml.jackson.databind.ObjectMapper;
import vip.epss.domain.User;
import vip.epss.service.UserService;
import vip.epss.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doProcess(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doProcess(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        Integer userSex = Integer.valueOf(request.getParameter("userSex"));
        User user = new User(userId,password,userName,userSex);
        UserService service = new UserServiceImpl();
        int result = service.saveUser(user);



        response.setCharacterEncoding("utf-8");
//告诉浏览器返回的数据是json格式，且以utf-8格式解码
        response.setContentType("application/json;charset=utf-8");//response.setHeader("Content-type", "text/json;charset=UTF-8");
        PrintWriter out =response.getWriter();
        ObjectMapper om =new ObjectMapper();
        out.print(om.writeValueAsString(result));
        out.close();

    }

}
