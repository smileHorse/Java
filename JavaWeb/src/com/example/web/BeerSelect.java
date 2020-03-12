package com.example.web;

import com.example.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class BeerSelect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("Beer Selection Advice<br>");
        String c = req.getParameter("color");
//        out.println("<br>Got beer color:" + c);

        BeerExpert expert = new BeerExpert();
        List result = expert.getBrands(c);
//        Iterator it = result.iterator();
//        while (it.hasNext()) {
//            out.print("<br>try: " + it.next());
//        }

        req.setAttribute("styles", result);

        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
    }
}
