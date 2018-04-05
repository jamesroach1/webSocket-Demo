package com.example.websocketdemo.controller;

import com.example.websocketdemo.model.CardPicture;
import com.example.websocketdemo.model.ChatMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

	/*
	 * /app will be routed to these message handling methods annotated with @MessageMapping
	 * /app/chat.sendMessage will be routed to the sendMessage() method
	 * /app/chat.addUser will be routed to the addUser() method.
	 */

    static final Logger logger = Logger.getLogger(ChatController.class);
	
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
       logger.info(chatMessage.getSender() + ", send a message");
        return chatMessage;
    }
    

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    
    
    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public String  handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        return "test";     
    }
}
