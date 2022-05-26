package com.revature.zahfosha.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.zahfosha.util.interfaces.Headable;

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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
        //CREATE
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
        // UPDATE
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
        //DELETE
    }

}
