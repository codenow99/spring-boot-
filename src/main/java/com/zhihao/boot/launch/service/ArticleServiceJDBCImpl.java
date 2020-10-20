package com.zhihao.boot.launch.service;

import com.zhihao.boot.launch.dao.ArticleJDBCDAO;
import com.zhihao.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleServiceJDBCImpl implements ArticleService {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    @Transactional
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article, primaryJdbcTemplate);
        articleJDBCDAO.save(article, secondaryJdbcTemplate);
        //int a = 10 / 0;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id, null);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if (article.getId() == null) {
            //TODO 抛出一个自定义异常
        }
        articleJDBCDAO.deleteById(article.getId(), null);
        articleJDBCDAO.save(article, null);
        //articleJDBCDAO.updateById(article);
        //int a = 10 / 0;//人为制造一个异常，用于测试事务
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id, null);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll(null);
    }
}
