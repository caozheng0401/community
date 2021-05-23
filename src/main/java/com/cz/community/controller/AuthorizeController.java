package com.cz.community.controller;

import com.cz.community.dto.AccessTokenDto;
import com.cz.community.dto.GithubUser;
import com.cz.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cz
 * @create 2021/5/20 18:32
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String sercret;

    @Value("${github.redirect.uri}")
    private String uri;



    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(sercret);
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri(uri);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        //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
        GithubUser user = githubProvider.getUser(accessToken);
        if (user != null){
            //登陆成功
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            //登陆失败
            return "redirect:/";
        }
    }
}
