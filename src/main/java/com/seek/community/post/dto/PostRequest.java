package com.seek.community.post.dto;

public record PostRequest(
    Long id,
    String title,
    String content,
    Long userId
) {

}
