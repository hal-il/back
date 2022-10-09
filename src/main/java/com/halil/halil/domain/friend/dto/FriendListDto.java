package com.halil.halil.domain.friend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class FriendListDto {
    private List<String> nicknames;
}
