package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.FormData;
import utils.ObjectStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FormDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream requestBody = req.getInputStream();

        String jsonBody = null;
        try (Scanner scanner = new Scanner(requestBody, StandardCharsets.UTF_8.name())) {
            jsonBody = scanner.useDelimiter("\\A").next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        FormData formDataServlet = mapper.readValue(jsonBody, FormData.class);


        ObjectStore.storeObject(formDataServlet);
        System.out.println(formDataServlet.getDescription());


    }
}
