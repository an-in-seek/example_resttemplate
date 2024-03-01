package com.seek.community.post.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seek.community.post.dto.PostRequest;
import com.seek.community.post.dto.PostResponse;
import com.seek.community.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@Tag(name = "Post API", description = "Post API 입니다.")
public class PostRestController {

    private final PostService postService;

    @PostMapping
    @Tag(name = "Post API")
    @Operation(summary = "Post 생성", description = "Post 정보를 생성합니다.")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest) {
        PostResponse postResponse = postService.createPost(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(postResponse);
    }

    @PutMapping("/{id}")
    @Tag(name = "Post API")
    @Operation(summary = "Post 변경", description = "Post 정보를 변경합니다.")
    public ResponseEntity<PostResponse> updatePost(@PathVariable long id, @RequestBody PostRequest postRequest) {
        postService.updatePost(id, postRequest);
        PostResponse postResponse = postService.getPost(id);
        return ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Post API")
    @Operation(summary = "Post 삭제", description = "Post 정보를 삭제합니다.")
    public ResponseEntity<PostResponse> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Tag(name = "Post API")
    @Operation(summary = "Post 조회", description = "Post 정보를 조회합니다.")
    public ResponseEntity<PostResponse> findPost(@PathVariable long id) {
        PostResponse postResponse = postService.getPost(id);
        return ResponseEntity.ok(postResponse);
    }

    @GetMapping
    @Tag(name = "Post API")
    @Operation(summary = "Post 리스트 조회", description = "Post 정보 리스트를 조회합니다.")
    public ResponseEntity<List<PostResponse>> getPostList(@RequestParam(required = false) Long userId) throws JsonProcessingException {
        List<PostResponse> postResponseList = postService.getPostList(userId);
        return ResponseEntity.ok(postResponseList);
    }

    @GetMapping("/pages")
    @Tag(name = "Post API")
    @Operation(summary = "Post 리스트 페이지 단위 조회", description = "Post 리스트 페이지 단위 조회")
    public ResponseEntity<Page<PostResponse>> getPostListByPage(
        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(required = false) Long userId
    ) throws JsonProcessingException {
        Page<PostResponse> postResponsePage = postService.getPostListByPage(pageNumber, pageSize, userId);
        return ResponseEntity.ok(postResponsePage);
    }
}
