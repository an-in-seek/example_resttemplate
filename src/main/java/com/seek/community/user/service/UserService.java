package com.seek.community.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seek.community.user.dto.UserRequest;
import com.seek.community.user.dto.UserResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final static String BASE_URL = "/users";

    public UserResponse createUser(UserRequest userRequest) {
        return restTemplate.postForObject(BASE_URL, userRequest, UserResponse.class);
    }

    public void updateUser(long id, UserRequest userRequest) {
        restTemplate.put(String.format("%s/%d", BASE_URL, id), userRequest);
    }

    public void deleteUser(long id) {
        restTemplate.delete(String.format("%s/%d", BASE_URL, id));
    }

    public UserResponse getUser(long id) {
        return restTemplate.getForEntity(String.format("%s/%d", BASE_URL, id), UserResponse.class).getBody();
    }

    public List<UserResponse> getUserList(Long id) throws JsonProcessingException {
        UriComponents uriBuilder = UriComponentsBuilder.fromUriString(BASE_URL)
            .queryParam("id", id)
            .build();
        ResponseEntity<String> response = restTemplate.getForEntity(uriBuilder.toUriString(), String.class);
        return objectMapper.readValue(response.getBody(), new TypeReference<>() {
        });
    }
}
