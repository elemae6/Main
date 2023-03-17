package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        Article d = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
        Article e = new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ");
        Article f = new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ");
        List<Article> expected = new ArrayList<>(Arrays.asList(a, b, c, d, e, f));

        List<Article> articles = articleService.index();
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_success() {
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");

        Article article = articleService.show(id);
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_fail() {
        Long id = -1L;
        Article expected = null;

        Article article = articleService.show(id);
        assertEquals(expected, article);

    }

    @Test
    @Transactional
    void create_success() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(7L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_fail() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_success1() {
        Long id = 2L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(2L, title, content);
        Article expected = new Article(id, title, content);

        Article article = articleService.update(id, dto);
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_success2() {
        Long id = 2L;
        String title = "라라라라";
        ArticleForm dto = new ArticleForm(2L, title, null);
        Article expected = new Article(id, title, "2222");

        Article article = articleService.update(id, dto);
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_fail1() {
        Long id = -1L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        Article article = articleService.update(id, dto);
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_fail2() {
        Long id = 2L;
        ArticleForm dto = new ArticleForm(null, null, null);
        Article expected = null;

        Article article = articleService.update(id, dto);
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_success() {
        Long id = 2L;
        Article expected = new Article(2L, "나나나나","2222");

        Article article = articleService.delete(id);
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void fail() {
        Long id = -1L;
        Article expected = null;

        Article article = articleService.delete(id);
        assertEquals(expected, article);
    }
}