import com.sun.net.httpserver.HttpServer;
import handler.TodoHandler;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/todos", new TodoHandler());

        server.setExecutor(null);
        System.out.println("Server started on http://localhost:8080/todos");
        server.start();
    }
    
}
