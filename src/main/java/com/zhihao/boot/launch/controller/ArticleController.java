package com.zhihao.boot.launch.controller;

import com.zhihao.boot.launch.AjaxResponse;
import com.zhihao.boot.launch.model.Article;
import com.zhihao.boot.launch.model.Reader;
import com.zhihao.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
//@RestController
@Controller
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    ArticleService articleService;

    //获取一篇文章
    //@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public @ResponseBody
    AjaxResponse getArticle(@PathVariable("id") Long id) {
        Article article = articleService.getArticle(id);
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }

    //新增一篇文章
    //@RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public @ResponseBody
    AjaxResponse saveArticle(@RequestBody Article article) {

        articleService.saveArticle(article);
        log.info("saveArticle:" + article);
        return AjaxResponse.success();
    }

//    @PostMapping("/articles")
//    public AjaxResponse saveArticle(
//            @RequestParam String author,
//            @RequestParam String title,
//            @RequestParam String content,
//            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//            @RequestParam Date createTime) {
//        log.info("saveArticle:" + createTime);
//        return AjaxResponse.success();
//    }

    //修改一篇文章
    //@RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public @ResponseBody
    AjaxResponse updateArticle(@RequestBody Article article) {
        if(article.getId() == null){
            //TODO 抛出一个异常
        }
        articleService.updateArticle(article);
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    //删除一篇文章
    //@RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public @ResponseBody
    AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }
    @GetMapping("/articles")
    public @ResponseBody
    AjaxResponse getArticle() {
        List<Article> articles = articleService.getAll();
        log.info("articles:" + articles);
        return AjaxResponse.success(articles);
    }


}
