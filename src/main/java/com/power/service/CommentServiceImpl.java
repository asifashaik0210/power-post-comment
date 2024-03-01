package com.power.service;

import com.power.entity.Comment;
import com.power.entity.Post;
import com.power.exception.ResourceNotFound;
import com.power.payload.CommentDto;
import com.power.repository.CommentRepository;
import com.power.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    private PostRepository postRepo;
    private CommentRepository commentRepo;

    public CommentServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public CommentServiceImpl(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public CommentDto createComment(long postId ,CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElseThrow(
                ()->new ResourceNotFound("post not found with id :"+postId)
        );
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment c = commentRepo.save(comment);
        return mapToDto(c);
    }
    Comment mapToEntity(CommentDto dto){
        Comment comment = new Comment();
        comment.setBody(dto.getBody());
        comment.setEmail(dto.getEmail());
        comment.setName(dto.getName());
        return comment;
    }
    CommentDto mapToDto(Comment comment){
        CommentDto commentDto = new  CommentDto();
        commentDto.setBody(comment.getBody());
        commentDto.setEmail(comment.getEmail());
        commentDto.setName(comment.getName());

        return commentDto;
    }
}
