package modelo.websocket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import main.Main;

@WebSocket
public class ServicioMensakesWebSocketHandler {



    @OnWebSocketConnect
    public void conectando(Session usuario){
        System.out.println("Conectando Uusario: " + usuario.getLocalAddress().getAddress().toString());
        Main.usuarioConectados.add(usuario);
    }

    @OnWebSocketClose
    public void cerrandoConexion(Session usuario, int statusCode, String reason) {
        System.out.println("Desconectando el usuario: " + usuario.getLocalAddress().getAddress().toString());
        Main.usuarioConectados.remove(usuario);
        
    }

    @OnWebSocketMessage
    public void recibiendoMensaje() {
        
        
    }



    
}