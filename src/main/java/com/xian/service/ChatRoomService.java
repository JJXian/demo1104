package com.xian.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: jjxian
 */
@Service
public class ChatRoomService {


    private final Map<String, Set<String>> chatRooms = new HashMap<>();

    /**
     * 加入聊天室，并打印聊天室内其他的成员
     * @param roomId
     * @param userId
     */
    public void joinRoom(String roomId, String userId) {
        chatRooms.putIfAbsent(roomId, new HashSet<>());
        Set<String> usersInRoom = chatRooms.get(roomId);

        if(usersInRoom.size() >0){
            System.out.println("在聊天室"+ roomId +"的其他成员：");
            for(String id : usersInRoom){
                if(!id.equals(userId)){
                    System.out.println(id);
                }
            }
        }else{
            System.out.println("没有别人在聊天室了！");
        }

        usersInRoom.add(userId);
    }

    /**
     * 离开了聊天室 同时打印还在聊天室的其他成员
     * @param roomId
     * @param userId
     */
    public void leaveRoom(String roomId, String userId) {
        Set<String> usersInRoom = chatRooms.get(roomId);
        if (usersInRoom != null && usersInRoom.contains(userId)) {
            usersInRoom.remove(userId);
            System.out.println(userId + "离开了" +roomId);

            if(usersInRoom.size() >0){
                System.out.println("还在聊天室"+ roomId +"的其他成员：");
                for(String id : usersInRoom){
                    if(!id.equals(userId)){
                        System.out.println(id);
                    }
                }
            }else{
                System.out.println("没有别人在聊天室了！");
            }

            if (usersInRoom.isEmpty()) {
                chatRooms.remove(roomId);
            }
        }
    }
}