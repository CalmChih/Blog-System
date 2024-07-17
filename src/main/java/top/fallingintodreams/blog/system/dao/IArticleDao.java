package top.fallingintodreams.blog.system.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fallingintodreams.blog.system.po.Article;

import java.util.List;
import java.util.Map;

@Mapper
public interface IArticleDao {
    
    void insertArticle(Article article);
    
    List<Article> getArticleList(Map<String, Object> searchMap);
    
    Article getArticle(Long postId);
    
    int updateArticle(Article article);
    
    int deleteArticle(Article article);
    
}
