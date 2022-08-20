package vip.epss.contorler;

import vip.epss.entity.vo.vo.MessageModel;
import vip.epss.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        MessageModel messageModel=userService.userLogin(userName,password);
   if(messageModel.getCode()==1){
       request.getSession().setAttribute("user",messageModel.getObject());
        response.sendRedirect("index.jsp");
   }else {
        request.setAttribute("messageModel",messageModel);
        request.getRequestDispatcher("login.jsp").forward(request,response);
   }



    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            doProcess(request,response);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String userId = request.getParameter("userId");
//        String password = request.getParameter("password");
//        String userName = request.getParameter("userName");
//        Integer userSex = Integer.valueOf(request.getParameter("userSex"));
//        User user = new User();
//        user.setUserid(userId);
//        user.setPassword(password);
//        user.setUsername(userName);
//        user.setUsersex(userSex);
//        UserService service = new UserServiceImpl();
//        int result = service.saveUser(user);
//
//
//
//        response.setCharacterEncoding("utf-8");
////告诉浏览器返回的数据是json格式，且以utf-8格式解码
//        response.setContentType("application/json;charset=utf-8");//response.setHeader("Content-type", "text/json;charset=UTF-8");
//        PrintWriter out =response.getWriter();
//        ObjectMapper om =new ObjectMapper();
//        out.print(om.writeValueAsString(result));
//        out.close();
//
//    }

}
