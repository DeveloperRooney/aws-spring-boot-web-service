package com.aws.rooney.service.article;

import com.aws.rooney.domain.article.Article;
import com.aws.rooney.domain.article.ArticleRepository;
import com.aws.rooney.web.dto.ArticleResponseDto;
import com.aws.rooney.web.dto.ArticleSaveRequestDto;
import com.aws.rooney.web.dto.ArticleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long save(ArticleSaveRequestDto requestDto) {
        return articleRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, ArticleUpdateRequestDto requestDto) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다. id=" + id));
        article.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public ArticleResponseDto findById(Long id) {
        Article entity = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다. id=" + id));

        return new ArticleResponseDto(entity);
    }
}
