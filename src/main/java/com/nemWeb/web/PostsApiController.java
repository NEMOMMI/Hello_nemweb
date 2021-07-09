package com.nemWeb.web;

import com.nemWeb.domain.posts.PostsService;

import com.nemWeb.web.dto.PostsResponseDto;
import com.nemWeb.web.dto.PostsSaveRequestDto;
import com.nemWeb.web.dto.PostsUpdateRequestDto;

//
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class PostsApiController {

    private final PostsService postsService;

    @PostMapping ("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //111
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requesDto) {
        return postsService.update(id, requesDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
