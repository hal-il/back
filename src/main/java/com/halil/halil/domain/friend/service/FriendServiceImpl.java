package com.halil.halil.domain.friend.service;

import com.halil.halil.domain.friend.dto.FriendListDto;
import com.halil.halil.domain.friend.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService{

    private final FriendRepository friendRepository;

    @Override
    public FriendListDto findFriendList(String email) {

        List<String> friendsNicknameList = friendRepository.findAllByUser_Email(email)
                                                            .stream()
                                                            .map(friend -> friend.getFriend().getNickname())
                                                            .collect(Collectors.toList());
        return new FriendListDto(friendsNicknameList);
    }
}
