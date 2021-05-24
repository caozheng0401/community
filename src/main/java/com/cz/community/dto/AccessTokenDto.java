package com.cz.community.dto;

import lombok.Data;

/**
 * @author cz
 * @create 2021/5/20 18:39
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret ;
    private String code;
    private String redirect_uri;
    private String state;


}
