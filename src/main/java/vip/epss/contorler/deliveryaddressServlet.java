package vip.epss.contorler;

import com.fasterxml.jackson.databind.ObjectMapper;
import vip.epss.domain.Deliveryaddress;
import vip.epss.service.DeliveryAddressService;
import vip.epss.service.DeliveryAddressServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "deliveryaddressServlet", value = "/deliveryaddressServlet")
public class deliveryaddressServlet extends HttpServlet {
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
        Deliveryaddress deliveryAddress = new Deliveryaddress();
        deliveryAddress.setDaid(Integer.valueOf(request.getParameter("daId")));
        deliveryAddress.setContactname(request.getParameter("contactName"));
        deliveryAddress.setContactsex(Integer.valueOf(request.getParameter("contactSex")));
        deliveryAddress.setContacttel(request.getParameter("contactTel"));
        deliveryAddress.setAddress(request.getParameter("address"));
        deliveryAddress.setUserid(request.getParameter("userId"));
        DeliveryAddressService service = new DeliveryAddressServiceImpl();
        int result = service.updateDeliveryAddress(deliveryAddress);


//        MessageAndDate.success("执行成功").add("regsta",)
        //将返回的数据编码成utf-8格式的字节流，与下面的content-type区别
        response.setCharacterEncoding("utf-8");
//告诉浏览器返回的数据是json格式，且以utf-8格式解码
        response.setContentType("application/json;charset=utf-8");//response.setHeader("Content-type", "text/json;charset=UTF-8");
        PrintWriter out =response.getWriter();
        ObjectMapper om =new ObjectMapper();
        out.print(om.writeValueAsString(result));
        out.close();
    }
}
