package com.aws.rooney.service.article;

import com.aws.rooney.domain.article.ArticleRepository;
import com.aws.rooney.web.dto.ArticleSaveRequestDto;
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
}
