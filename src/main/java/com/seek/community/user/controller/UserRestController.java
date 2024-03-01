package com.seek.community.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seek.community.user.dto.UserRequest;
import com.seek.community.user.dto.UserResponse;
import com.seek.community.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/v1/users")
@Tag(name = "User API", description = "User API 입니다.")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    @Tag(name = "User API")
    @Operation(summary = "User 생성", description = "User 정보를 생성합니다.")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PutMapping("/{id}")
    @Tag(name = "User API")
    @Operation(summary = "User 변경", description = "User 정보를 변경합니다.")
    public ResponseEntity<UserResponse> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest) {
        userService.updateUser(id, userRequest);
        UserResponse userResponse = userService.getUser(id);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "User API")
    @Operation(summary = "User 삭제", description = "User 정보를 삭제합니다.")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Tag(name = "User API")
    @Operation(summary = "User 조회", description = "User 정보를 조회합니다.")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id) {
        UserResponse userResponse = userService.getUser(id);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    @Tag(name = "User API")
    @Operation(summary = "User 리스트 조회", description = "User 정보 리스트를 조회합니다.")
    public ResponseEntity<List<UserResponse>> getUserList(@RequestParam(required = false) Long id) throws JsonProcessingException {
        List<UserResponse> userResponseList = userService.getUserList(id);
        return ResponseEntity.ok(userResponseList);
    }
}
