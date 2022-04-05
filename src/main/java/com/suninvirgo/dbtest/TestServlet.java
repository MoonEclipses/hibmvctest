package com.suninvirgo.dbtest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "postgres";
        String pass = "postgres";

        String url = "jdbc:postgresql://localhost:5432/hibmvc";
        String driver = "org.postgresql.Driver";
        PrintWriter pw = resp.getWriter();
        try {
            pw.println("Connecting to db...");
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,pass);
            pw.println("Connection success!");
            connection.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }


    }
}
