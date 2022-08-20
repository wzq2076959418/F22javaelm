package vip.epss.contorler;

import com.fasterxml.jackson.databind.ObjectMapper;
import vip.epss.domain.Deliveryaddress;
import vip.epss.domain.User;
import vip.epss.service.DeliveryAddressService;
import vip.epss.service.DeliveryAddressServiceImpl;
import vip.epss.service.UserService;
import vip.epss.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deliveryaddressServlet", value = "/deliveryaddressServlet")
public class getUserByIdByPassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doProcess(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doProcess(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        UserService service = new UserServiceImpl();
        User user = service.getUserByIdByPass(userId, password);
        if(user!=null) {
            request.getSession().setAttribute("user", user);
        }


//        MessageAndDate.success("执行成功").add("regsta",)
        //将返回的数据编码成utf-8格式的字节流，与下面的content-type区别
        response.setCharacterEncoding("utf-8");
//告诉浏览器返回的数据是json格式，且以utf-8格式解码
        response.setContentType("application/json;charset=utf-8");//response.setHeader("Content-type", "text/json;charset=UTF-8");
        PrintWriter out =response.getWriter();
        ObjectMapper om =new ObjectMapper();
        out.print(om.writeValueAsString(user));
        out.close();
    }
}
