import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    
    String display = "";

    public String handleRequest(URI url) {

        if(url.getPath().equals("/add-message")){
            if(url.getQuery().startsWith("s=")){
                String newMessage = url.getQuery().substring(2, url.getQuery().length());
                display = display + "\n" + newMessage;
            }
        }
        System.out.println(display);
        return display;
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

