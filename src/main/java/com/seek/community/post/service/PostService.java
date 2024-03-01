package com.seek.community.post.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seek.community.post.dto.PostRequest;
import com.seek.community.post.dto.PostResponse;
import com.seek.community.post.model.Post;
import com.seek.community.post.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class PostService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final PostRepository postRepository;
    private final static String BASE_URL = "/posts";

    public PostResponse createPost(PostRequest postRequest) {
        return restTemplate.postForObject(BASE_URL, postRequest, PostResponse.class);
    }

    public void updatePost(long id, PostRequest postRequest) {
        restTemplate.put(String.format("%s/%d", BASE_URL, id), postRequest);
    }

    public void deletePost(long id) {
        restTemplate.delete(String.format("%s/%d", BASE_URL, id));
    }

    public PostResponse getPost(long id) {
        return restTemplate.getForEntity(String.format("%s/%d", BASE_URL, id), PostResponse.class).getBody();
    }

    public List<PostResponse> getPostList(Long userId) throws JsonProcessingException {
        UriComponents uriBuilder = UriComponentsBuilder.fromUriString(BASE_URL)
            .queryParam("userId", userId)
            .build();
        ResponseEntity<String> response = restTemplate.getForEntity(uriBuilder.toUriString(), String.class);
        return objectMapper.readValue(response.getBody(), new TypeReference<>() {
        });
    }

    public Page<PostResponse> getPostListByPage(int pageNumber, int pageSize, Long userId) throws JsonProcessingException {
        saveFromGetPostList(userId);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return postRepository.findAll(pageable).map(Post::toResponse);
    }

    private void saveFromGetPostList(Long userId) throws JsonProcessingException {
        UriComponents uriBuilder = UriComponentsBuilder.fromUriString(BASE_URL)
            .queryParam("userId", userId)
            .build();
        ResponseEntity<String> response = restTemplate.getForEntity(uriBuilder.toUriString(), String.class);
        List<Post> postList = objectMapper.readValue(response.getBody(), new TypeReference<>() {
        });
        postRepository.saveAll(postList);
    }
}
