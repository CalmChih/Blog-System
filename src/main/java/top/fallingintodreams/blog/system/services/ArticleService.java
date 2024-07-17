package top.fallingintodreams.blog.system.services;

import top.fallingintodreams.blog.system.common.ApiResponse;
import top.fallingintodreams.blog.system.po.Article;

import java.util.Map;

public interface ArticleService {
    
    ApiResponse createArticle(Article article);
    
    ApiResponse getArticleList(Long userId, Map<String, Object> searchMap);
    
    ApiResponse getArticle(Long postId);
    
    ApiResponse updateArticle(Long postId, Article article);
    
    ApiResponse deleteArticle(Long postId);
    
}
