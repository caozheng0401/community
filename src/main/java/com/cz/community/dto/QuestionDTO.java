package com.cz.community.dto;

import com.cz.community.model.User;
import lombok.Data;

/**
 * @author cz
 * @create 2021/5/24 15:44
 */
@Data
public class QuestionDTO {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
