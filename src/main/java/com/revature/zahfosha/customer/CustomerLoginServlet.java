package com.revature.zahfosha.customer;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static com.revature.zahfosha.util.interfaces.Headable.addHeads;

public class CustomerLoginServlet extends HttpServlet {

    private final CustomerServices cServ;
    private final CustomerDao cDao;
    private final ObjectMapper mapper;

    public CustomerLoginServlet(CustomerServices cServ, CustomerDao cDao, ObjectMapper mapper) {
        this.cServ = cServ;
        this.cDao = cDao;
        this.mapper = mapper;
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        addHeads(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        addHeads(req, resp);

        CustomerDTO pass = mapper.readValue(req.getInputStream(), CustomerDTO.class);

        CustomerModel authCustomer = cServ.authenticateAccount(pass.getCustomerUsername(), pass.getPassword(), pass.getIsAdmin());

        if (pass.getIsAdmin() == 1){
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("authAdminAccount", authCustomer);

            String payload = mapper.writeValueAsString(authCustomer);

            resp.getWriter().write("Customer was authenticated as an Admin \n");
            resp.getWriter().write(payload);
            resp.setStatus(201);
        }
        else {
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("authAccount", authCustomer);

            String payload = mapper.writeValueAsString(authCustomer);

            resp.getWriter().write("Customer was authenticated as a Customer \n");
            resp.getWriter().write(payload);
            resp.setStatus(201);
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req,resp);

        req.getSession().invalidate();
        resp.getWriter().write("User has logged out!");
    }

}
