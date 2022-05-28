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

//    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doOptions(req, resp);
//        addHeads(req, resp);
//    }

    //CREATE
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        addHeads(req, resp);
        OrdersDTO pass = mapper.readValue(req.getInputStream(), OrdersDTO.class);

        OrdersModel addedOrder = oDao.createCustomOrder(pass.getId(), pass.getMenuItem(), pass.getComment(), pass.getIsFavorite(), pass.getOrderDate(), pass.getCustomerUsername());

        String payload = mapper.writeValueAsString(addedOrder);

        resp.getWriter().write("Added the order, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

    //READ
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        addHeads(req, resp);
        OrdersDTO pass = mapper.readValue(req.getInputStream(), OrdersDTO.class);

        OrdersModel[] orders = oDao.viewAllByDate(pass.getTheDate());

        String payload = mapper.writeValueAsString(orders);

        resp.getWriter().write("Orders populated, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

}
