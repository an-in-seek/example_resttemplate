package com.seek.community.post.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public record PostResponse(
    Long id,
    String title,
    String content,
    @JsonProperty("UserId")
    Long userId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
