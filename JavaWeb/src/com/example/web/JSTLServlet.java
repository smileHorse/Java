package com.example.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSTLServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] movieList = {"Amelie", "Return of the king", "Mean Girls"};
        req.setAttribute("movieList", movieList);

        RequestDispatcher view = req.getRequestDispatcher("jstl-1.jsp");
        view.forward(req, resp);
    }
}
