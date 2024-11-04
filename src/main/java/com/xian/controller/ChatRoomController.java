package com.xian.controller;


import com.xian.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @Author: jjxian
 */

@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {

    @Autowired
    private  ChatRoomService chatRoomService;


    /**
     * 加入聊天室
     * @param roomId
     * @param userId
     * @return
     */
    @PostMapping("/join")
    public String joinRoom(@RequestParam String roomId, @RequestParam String userId) {
        chatRoomService.joinRoom(roomId, userId);
        return "用户" + userId + "加入了" + roomId;
    }

    /**
     * 离开聊天室
     * @param roomId
     * @param userId
     * @return
     */
    @PostMapping("/leave")
    public String leaveRoom(@RequestParam String roomId, @RequestParam String userId) {
        chatRoomService.leaveRoom(roomId, userId);
        return "用户" + userId + "离开了" + roomId;
    }
}
