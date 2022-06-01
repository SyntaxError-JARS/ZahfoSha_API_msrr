package com.revature.zahfosha.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.zahfosha.menu.MenuDTO;
import com.revature.zahfosha.menu.MenuModel;
import com.revature.zahfosha.util.interfaces.Headable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.revature.zahfosha.util.interfaces.Headable.addHeads;

public class CustomerServlet extends HttpServlet {

    private final CustomerDao cDao;
    private final ObjectMapper mapper;


    public CustomerServlet(CustomerDao cDao, ObjectMapper mapper) {
        this.cDao = cDao;
        this.mapper = mapper;
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        addHeads(req, resp);
    }

    //CREATE
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);

        CustomerDTO pass = mapper.readValue(req.getInputStream(), CustomerDTO.class);

        CustomerModel createdCustomer = cDao.createCustomer(pass.getUsername(), pass.getFName(), pass.getLName(), pass.getPassword(), pass.getBalance(), pass.getIsAdmin());

        String payload = mapper.writeValueAsString(createdCustomer);

        resp.getWriter().write("Added the new customer, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }

    //UPDATE
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);

        CustomerDTO pass = mapper.readValue(req.getInputStream(), CustomerDTO.class);

        CustomerModel theResults = cDao.updateCustomer(pass.getFName(), pass.getLName(), pass.getPassword(), pass.getBalance(), pass.getUsername());

        String payload = mapper.writeValueAsString(theResults);

        resp.getWriter().write("Updated the customer, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }

    //DELETE
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
//        addHeads(req, resp);
        CustomerDTO pass = mapper.readValue(req.getInputStream(), CustomerDTO.class);

        boolean deleteTrue = cDao.deleteCustomer(pass.getUsername());

        String payload = mapper.writeValueAsString(deleteTrue);

        resp.getWriter().write("Customer was deleted. See true below to verify \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

}
