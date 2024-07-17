package top.fallingintodreams.blogsystem.po;

import lombok.Data;

import java.util.Date;

@Data
public class article {
    
    private Long postId;
    private String title;
    private String content;
    private Long userId;
    private Date created;
    private Date lastModified;
    
}
