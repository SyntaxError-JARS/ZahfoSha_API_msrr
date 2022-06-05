package com.revature.zahfosha.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.zahfosha.util.exceptions.InvalidRequestException;
import com.revature.zahfosha.util.exceptions.ResourcePersistenceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.revature.zahfosha.util.interfaces.AdminAuthable.checkAdminAuth;
import static com.revature.zahfosha.util.interfaces.Headable.addHeads;

public class MenuServlet extends HttpServlet {

    private final MenuDao mDao;
    private final MenuServices mServ;
    private final ObjectMapper mapper;

    public MenuServlet(MenuDao mDao, MenuServices mServ, ObjectMapper mapper) {
        this.mDao = mDao;
        this.mServ = mServ;
        this.mapper = mapper;
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        addHeads(req, resp);
    }

    //CREATE
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);

        if(!checkAdminAuth(req, resp)){return;}

        MenuModel addedItem;
        try {
            MenuModel newMenuItem = mapper.readValue(req.getInputStream(), MenuModel.class);
            addedItem = mServ.create(newMenuItem);
        } catch (InvalidRequestException e) {
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
            return;
        }

        String payload = mapper.writeValueAsString(addedItem);

        resp.getWriter().write("Added the new menu item, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }



    //UPDATE
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);

        if(!checkAdminAuth(req, resp)){return;}

        MenuDTO pass = mapper.readValue(req.getInputStream(), MenuDTO.class);

        MenuModel theResults = mDao.updateMenu(pass.getMenuItem(), pass.getCost(), pass.getProtein(), pass.getIsSubstitutable());

        String payload = mapper.writeValueAsString(theResults);

        resp.getWriter().write("Updated the menu item, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

    //DELETE
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);

        if(!checkAdminAuth(req, resp)){return;}

        MenuDTO pass = mapper.readValue(req.getInputStream(), MenuDTO.class);

        try {
            boolean deletedMenuItem = mDao.deleteByMenuItem(pass.getMenuItem());

            String payload = mapper.writeValueAsString(deletedMenuItem);

            resp.getWriter().write("Delete menu item from the database, see true below ");
            req.getSession().invalidate();
            resp.getWriter().write(payload);
            resp.setStatus(201);
        } catch (ResourcePersistenceException e) {
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
            resp.setStatus(500);
        }

    }

    //READ
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addHeads(req, resp);


        List<MenuModel> gotTheMenu = mDao.findAllMenuItems();

        String payload = mapper.writeValueAsString(gotTheMenu);

        resp.getWriter().write("Added the new menu item, as seen below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }

}
