package top.fallingintodreams.blog.system.services.impl;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.fallingintodreams.blog.system.common.ApiResponse;
import top.fallingintodreams.blog.system.dao.IArticleDao;
import top.fallingintodreams.blog.system.po.Article;
import top.fallingintodreams.blog.system.services.ArticleService;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Resource
    private IArticleDao articleDao;
    
    @Override
    public ApiResponse createArticle(Article article) {
        long userId = StpUtil.getLoginIdAsLong();
        article.setUserId(userId);
        articleDao.insertArticle(article);
        return ApiResponse.success();
    }
    
    @Override
    public ApiResponse getArticleList(Long userId, Map<String, Object> searchMap) {
        searchMap.put("userId", userId);
        List<Article> articleList = articleDao.getArticleList(searchMap);
        return ApiResponse.success(articleList);
    }
    
    @Override
    public ApiResponse getArticle(Long postId) {
        Article article = articleDao.getArticle(postId);
        return ApiResponse.success(article);
    }
    
    @Override
    public ApiResponse updateArticle(Long postId, Article article) {
        long userId = StpUtil.getLoginIdAsLong();
        article.setUserId(userId);
        article.setPostId(postId);
        int count = articleDao.updateArticle(article);
        if (count <= 0) {
            return ApiResponse.error("更新失败");
        }
        return ApiResponse.success();
    }
    
    @Override
    public ApiResponse deleteArticle(Long postId) {
        long userId = StpUtil.getLoginIdAsLong();
        Article article = new Article();
        article.setUserId(userId);
        article.setPostId(postId);
        int count = articleDao.deleteArticle(article);
        if (count <= 0) {
            return ApiResponse.error("删除失败");
        }
        return ApiResponse.success();
    }
    
}
