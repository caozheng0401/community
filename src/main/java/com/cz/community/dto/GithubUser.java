package com.cz.community.dto;

import lombok.Data;

/**
 * @author cz
 * @create 2021/5/20 19:05
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;

}
