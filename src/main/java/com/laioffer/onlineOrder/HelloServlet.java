package com.laioffer.onlineOrder;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // 我们新建了一个customer，可以接受参数，比如自己放一个名字
        //String customer = request.getParameter("customer");

        JSONObject customer = new JSONObject();
        customer.put("email", "sun@laioffer.com");
        customer.put("first_name", "rick");
        customer.put("last_name", "sun");
        customer.put("age", 50);
        response.getWriter().print(customer);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}