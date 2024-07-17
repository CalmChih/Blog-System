package top.fallingintodreams.blog.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fallingintodreams.blog.system.common.ApiResponse;
import top.fallingintodreams.blog.system.po.Article;
import top.fallingintodreams.blog.system.services.ArticleService;

import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class ArticleController {
    
    @Resource
    private ArticleService articleService;
    
    @SaCheckLogin
    @PostMapping
    public ApiResponse createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }
    
    @GetMapping
    public ApiResponse getArticleList(@RequestParam(name = "uid") Long userId, @RequestBody Map<String, Object> searchMap) {
        return articleService.getArticleList(userId, searchMap);
    }
    
    @GetMapping("/{id}")
    public ApiResponse getArticle(@PathVariable(name = "id") Long postId) {
        return articleService.getArticle(postId);
    }
    
    @SaCheckLogin
    @PutMapping("/{id}")
    public ApiResponse updateArticle(@PathVariable(name = "id") Long postId, @RequestBody Article article) {
        return articleService.updateArticle(postId, article);
    }
    
    @SaCheckLogin
    @DeleteMapping("/{id}")
    public ApiResponse deleteArticle(@PathVariable(name = "id") Long postId) {
        return articleService.deleteArticle(postId);
    }
    
}
