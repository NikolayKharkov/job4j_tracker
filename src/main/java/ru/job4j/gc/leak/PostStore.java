package ru.job4j.gc.leak;

import java.util.*;

public class PostStore {

    private Map<Integer, Post> posts = new HashMap<>();

    private int postIndex = 1;

    public Post add(Post post) {
        postIndex++;
        post.setId(postIndex);
        posts.put(postIndex, post);
        return post;
    }

    public void removeAll() {
        posts.clear();
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }
}