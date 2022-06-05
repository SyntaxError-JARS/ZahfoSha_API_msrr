package com.revature.zahfosha.orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.zahfosha.menu.MenuModel;
import com.revature.zahfosha.util.exceptions.InvalidRequestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.revature.zahfosha.util.interfaces.Headable.addHeads;
import static com.revature.zahfosha.util.interfaces.NormalAuthable.checkAuth;

public class OrdersServlet extends HttpServlet {

    private final OrdersDao oDao;
    private final OrdersServices oServ;
    private final ObjectMapper mapper;

    public OrdersServlet(OrdersDao oDao, OrdersServices oServ, ObjectMapper mapper) {
        this.oDao = oDao;
        this.oServ = oServ;
        this.mapper = mapper;
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        addHeads(req, resp);
    }

//    //CREATE
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);

        if(!checkAuth(req, resp)){return;}

        OrdersModel addedOrder;
        try {
            OrdersModel newOrder = mapper.readValue(req.getInputStream(), OrdersModel.class);
            addedOrder =oServ.create(newOrder);
        } catch (InvalidRequestException e){
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
            return;
        }

        String payload = mapper.writeValueAsString(addedOrder);

        resp.getWriter().write("Added the new order, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }

    //READ
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);

        List<OrdersModel> gotDates = oDao.viewAllByDate();

        String payload = mapper.writeValueAsString(gotDates);

        resp.getWriter().write("Orders populated, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

}
