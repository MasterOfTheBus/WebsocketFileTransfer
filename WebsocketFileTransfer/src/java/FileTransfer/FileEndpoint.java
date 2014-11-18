/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

/**
 *
 * @author 
 */
@ServerEndpoint("/transfer")
public class FileEndpoint {
    
    static int BUFFER_SIZE =  4096;
    
    @OnMessage
    public String sendFile(String message, Session session) {
        if (message == null) {
            return ("ERROR");
        }
        
        // check if file exists
        message = "C:\\cygwin\\home\\Lazy\\workspace\\Telecom\\WebsocketFileTransfer\\WebsocketFileTransfer\\send\\" + message;
        File f = new File(message);
        
        // open file and send send as a binary message
        try {
            FileInputStream in = new FileInputStream(f);
            OutputStream out = session.getBasicRemote().getSendStream();
            byte[] bArray = new byte[BUFFER_SIZE];
            
            int read = in.read(bArray);
            while (read != -1) {          
                out.write(bArray);
                read = in.read(bArray);
            }
            out.flush();
        } catch (Exception e) {
            return e.getMessage();
        }
        
        return ("File Sent");
    }
}
