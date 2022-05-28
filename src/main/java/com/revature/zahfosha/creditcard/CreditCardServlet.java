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

//    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doOptions(req, resp);
//        addHeads(req, resp);
//    }

    //CREATE
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        addHeads(req, resp);
        CreditCardDTO pass = mapper.readValue(req.getInputStream(), CreditCardDTO.class);

        CreditCardModel firstResult = cDao.addCC(pass.getCcNumber(), pass.getCcName(), pass.getCvv(), pass.getExpDate(), pass.getZip(), pass.getLimit(), pass.getCustomerUsername());

        CreditCardModel theObject = cDao.followUpAddCC(pass.getCcNumber());

        String payload = mapper.writeValueAsString(theObject);

        resp.getWriter().write("Added the credit card, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

    //UPDATE
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        addHeads(req, resp);
    }

    //DELETE
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        addHeads(req, resp);
        CreditCardDTO pass = mapper.readValue(req.getInputStream(), CreditCardDTO.class);

        boolean deleteTrue = cDao.deleteByCCNumber(pass.getCcNumber());

        String payload = mapper.writeValueAsString(deleteTrue);

        resp.getWriter().write("Account was deleted, see true near bottom to verify \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

}
