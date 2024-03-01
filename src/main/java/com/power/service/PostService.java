package com.power.service;

import com.power.payload.PostDto;

import java.util.List;

public interface PostService {
   PostDto createPost(PostDto postDto);
   void deletePostById(long id);
   PostDto getPostById(long id);
   PostDto updatePost(long id,PostDto postDto);
}
