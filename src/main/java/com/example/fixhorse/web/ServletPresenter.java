package com.example.fixhorse.web;

import com.example.fixhorse.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ServletPresenter extends HttpServlet {
    @Autowired
    private BoardService boardService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pathLength = boardService.calculate(
                Integer.parseInt(req.getParameter("width")),
                Integer.parseInt(req.getParameter("height")),
                req.getParameter("start"),
                req.getParameter("end")
        );
        PrintWriter writer = resp.getWriter();
        writer.println(pathLength);
        writer.close();
    }
}
