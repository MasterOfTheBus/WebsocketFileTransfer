/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTransfer;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author 
 */
@ServerEndpoint("/transfer")
public class FileEndpoint {
    
    @OnMessage
    public String echo(String message) {
        return message;
    }
}
