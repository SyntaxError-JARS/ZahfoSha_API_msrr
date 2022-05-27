package com.revature.zahfosha.creditcard;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.revature.zahfosha.util.interfaces.Headable.addHeads;

public class CreditCardServlet extends HttpServlet {

    private final CreditCardDao cDao;
    private final ObjectMapper mapper;

    public CreditCardServlet(CreditCardDao cDao, ObjectMapper mapper) {
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
    }

    //UPDATE
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
    }

    //DELETE
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);
    }

}
