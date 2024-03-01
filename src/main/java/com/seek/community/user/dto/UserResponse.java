package com.seek.community.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
public record UserResponse(
    Long id,
    String name,
    String username,
    String email,
    String phone,
    String website,
    String province,
    String city,
    String district,
    String street,
    String zipcode,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
