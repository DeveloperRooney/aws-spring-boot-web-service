package com.aws.rooney.web;

import com.aws.rooney.service.article.ArticleService;
import com.aws.rooney.web.dto.ArticleSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;

    @PostMapping("/api/vi/article")
    public Long save(@RequestBody ArticleSaveRequestDto requestDto) {

        return articleService.save(requestDto);
    }
}
