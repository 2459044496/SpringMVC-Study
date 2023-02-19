package cn.cuiper.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test extends HttpServlet {

    // Servlet示例
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.getSession().setAttribute("name", name);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
}
