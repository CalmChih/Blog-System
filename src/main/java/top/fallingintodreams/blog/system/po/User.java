package top.fallingintodreams.blog.system.po;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private Date created;
    private Date lastModified;

}
