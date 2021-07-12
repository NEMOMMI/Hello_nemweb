package com.nemWeb.web;

import com.nemWeb.config.auth.LoginUser;
import com.nemWeb.config.auth.dto.SessionUser;
import com.nemWeb.domain.posts.PostsService;
import com.nemWeb.web.dto.PostsResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller

public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    //save
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    //update(155)
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
