package com.seek.community.user.dto;

public record UserRequest(
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
    String zipcode
) {

}
