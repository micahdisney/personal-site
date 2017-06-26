package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostsController {

    private final PostSvc postSvc;
    private final UsersRepository usersDao;

    @Autowired
    public PostsController(PostSvc postSvc, UsersRepository usersDao) {
        this.postSvc = postSvc;
        this.usersDao = usersDao;
    }


    @GetMapping("/posts")
    public String viewAll(Model model) {
        Iterable<Post> posts = postSvc.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable Long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            Model model
    ) {

        User user = usersDao.findOne(1L);
        Post post = new Post(title, body, user);
        postSvc.save(post);
        model.addAttribute("post", post);
        return "posts/create";
    }


    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/post/delete")
    public String deletePost(@ModelAttribute Post post, Model model){
        postSvc.deletePost(post.getId());
        model.addAttribute("msg", "Your post was deleted correctly");
        return "return the view with a success message";
    }

}
