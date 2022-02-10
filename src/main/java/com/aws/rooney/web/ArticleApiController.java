package com.aws.rooney.web;

import com.aws.rooney.service.article.ArticleService;
import com.aws.rooney.web.dto.ArticleResponseDto;
import com.aws.rooney.web.dto.ArticleSaveRequestDto;
import com.aws.rooney.web.dto.ArticleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;

    @PostMapping("/api/v1/article")
    public Long save(@RequestBody ArticleSaveRequestDto requestDto) {

        return articleService.save(requestDto);
    }

    @PutMapping("/api/v1/article/{id}")
    public Long update(@PathVariable("id") Long id, @RequestBody ArticleUpdateRequestDto requestDto) {
        return articleService.update(id, requestDto);

    }

    @GetMapping("/api/v1/article/{id}")
    public ArticleResponseDto findById (@PathVariable("id") Long id) {
        return articleService.findById(id);
    }
}
