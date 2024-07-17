package top.fallingintodreams.blogsystem.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fallingintodreams.blogsystem.common.ApiResponse;

@RestController
@RequestMapping("/api/posts")
public class ArticleController {
    
    @PostMapping
    public ApiResponse createArticle() {
        return ApiResponse.success();
    }
    
    @GetMapping
    public ApiResponse getArticleList(@RequestParam(name = "uid") Long userId) {
        return ApiResponse.success();
    }
    
    @GetMapping("/{id}")
    public ApiResponse getArticle(@PathVariable(name = "id") Long postId) {
        return ApiResponse.success();
    }
    
    @PutMapping("/{id}")
    public ApiResponse updateArticle(@PathVariable(name = "id") Long postId) {
        return ApiResponse.success();
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse deleteArticle(@PathVariable(name = "id") Long postId) {
        return ApiResponse.success();
    }
    
}
