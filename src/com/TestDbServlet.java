package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private Environment environment;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            DBConnection dbConnection = context.getBean(DBConnection.class);
            Connection connection = dbConnection.getConnection();

            out.println("Connecting to database: " + connection.getCatalog());
            out.println("SUCCESS");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAIL");
        }
    }
}
