package com.halil.halil.domain.friend.service;

import com.halil.halil.domain.friend.dto.FriendListDto;

public interface FriendService {
    FriendListDto findFriendList(String email);
}
