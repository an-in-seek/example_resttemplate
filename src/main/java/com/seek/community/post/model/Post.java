package com.seek.community.post.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seek.community.post.dto.PostResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    private Long id;

    @Column(length = 500)
    private String title;

    @Column(length = 1000)
    private String content;

    @JsonProperty("UserId")
    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public PostResponse toResponse() {
        return PostResponse.builder()
            .id(id)
            .title(title)
            .content(content)
            .userId(userId)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .build();
    }
}
