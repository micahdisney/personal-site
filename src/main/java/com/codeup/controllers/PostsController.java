package com.codeup.controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
public class PostsController {
    @GetMapping("/posts")
    public String viewAll(Model model) {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("Number 1", "Here is a blog post"));
        posts.add(new Post("Number 2", "Here is blog post 2"));

        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable Long id, Model model) {
        Post post = new Post("test testing", "my blog post");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showPostForm() {
        return "view creating post form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "create new post";
    }
}
