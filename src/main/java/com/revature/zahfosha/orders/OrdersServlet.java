package com.revature.zahfosha.orders;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.revature.zahfosha.util.interfaces.Headable.addHeads;

public class OrdersServlet extends HttpServlet {

    private final OrdersDao oDao;
    private final ObjectMapper mapper;

    public OrdersServlet(OrdersDao oDao, ObjectMapper mapper) {
        this.oDao = oDao;
        this.mapper = mapper;
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        addHeads(req, resp);
    }

    //CREATE
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
    }

    //READ
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
    }

}
