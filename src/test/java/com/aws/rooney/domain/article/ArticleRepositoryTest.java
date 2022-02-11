package com.aws.rooney.domain.article;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

//    @AfterEach
//    public void cleanUp() {
//        articleRepository.deleteAll();
//    }

    @Test
    public void getArticle() {

        String title = "테스트 게시글 제목";
        String content = "테스트 게시글 본문";

        articleRepository.save(Article.builder().
                title(title).
                content(content).
                author("wayne_10@naver.com").
                build());

        List<Article> articleList = articleRepository.findAll();

        Article article = articleList.get(0);

        assertThat(article.getTitle()).isEqualTo(title);
        assertThat(article.getContent()).isEqualTo(content);
    }

    @Test
    public void createBaseTimeEntity() {
        // given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);

        articleRepository.save(Article.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // when
        List<Article> articleList = articleRepository.findAll();

        assertThat(articleList.get(0).getCreatedDate()).isAfter(now);

    }
}
