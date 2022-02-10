package com.aws.rooney.web.dto;

import com.aws.rooney.domain.article.Article;
import lombok.Getter;

@Getter
public class ArticleResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public ArticleResponseDto(Article entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
