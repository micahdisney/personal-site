package com.codeup.svcs;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("postSvc")
public class PostSvc {

    List<Post> posts = new ArrayList<>();

    public PostSvc(){
        createPosts();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post findOne(long id){
        return posts.get((int) id - 1);
    }

    public Post save(Post post){
        post.setId(( long) posts.size() + 1);
        posts.add(post);
        return post;
    }

    private void createPosts(){
        save(new Post("car", "very fast"));
        save(new Post("horse", "not as fast"));
        save(new Post("dog", "friendly"));
        save(new Post("snail", "very slow"));
    }

    public void createPost(String title, String body){
        save(new Post(title, body));
    }



}