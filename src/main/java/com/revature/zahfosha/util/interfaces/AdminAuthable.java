package com.revature.zahfosha.util.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface AdminAuthable {

    static boolean checkAdminAuth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("authAdminAccount") == null){
            resp.getWriter().write("Unauthorized request - not logged in as a registered user");
            resp.setStatus(401);
            return false;

        }
        return true;
    }

}
