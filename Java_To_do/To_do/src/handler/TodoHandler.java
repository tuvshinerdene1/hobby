package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dao.TodoDAO;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;


public class TodoHandler implements HttpHandler {
    private TodoDAO dao = new TodoDAO();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String response = "";

        try {
        if ("GET".equals(method)){
            response = dao.getAll().toString();
            exchange.sendResponseHeaders(200, response.length());
        }
        else if ("POST".equals(method)){
            String body = new BufferedReader(new InputStreamReader(exchange.getRequestBody())).lines().collect(Collectors.joining("\n"));
            dao.add(body);
            response = "Added successfully";
            exchange.sendResponseHeaders(201, response.length());
        }
        else if ("PUT".equals(method)){
            Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
            int id = Integer.parseInt(params.get("id"));
            String body = new BufferedReader(new InputStreamReader(exchange.getRequestBody())).lines().collect(Collectors.joining("\n"));
            dao.update(id, body, true);
            response = "Updated successfully";
            exchange.sendResponseHeaders(200, response.length());
        }
        } catch (Exception e){
            response = "Error: " + e.getMessage();
            exchange.sendResponseHeaders(400, response.length());
        }



        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }


    private Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<>();
        if (query == null) return result;
        for (String param : query.split("&")){
            String[] entry = param.split("=");
            if(entry.length > 1){
                result.put(entry[0], entry[1]);
            }
        }
        return result;
    };
    
    
}
