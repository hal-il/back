package com.halil.halil.domain.friend.controller;

import com.halil.halil.domain.friend.service.FriendService;
import com.halil.halil.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    @GetMapping
    public ResponseEntity<CommonResponse> getFriendsByEmail(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        return ResponseEntity.ok(CommonResponse.createSuccess(friendService.findFriendList(email)));
    }
}
