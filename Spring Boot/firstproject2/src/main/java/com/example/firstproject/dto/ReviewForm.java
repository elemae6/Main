package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.entity.Review;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ReviewForm {
    private Long id;
    private String name;

    private String content;

    public Review toEntity() {
        return new Review(id, name, content);
    }

}