package com.cz.community.model;

import lombok.Data;

/**
 * @author cz
 * @create 2021/5/23 21:41
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
