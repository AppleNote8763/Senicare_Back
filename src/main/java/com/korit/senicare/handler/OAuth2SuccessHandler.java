package com.korit.senicare.handler;

import java.io.IOException;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.korit.senicare.common.object.CustomOAuth2User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// OAuth2 유저 서비스 작업이 성공했을 때 처리
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication
    ) throws IOException, ServletException {

        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String userId = customOAuth2User.getName();
        Map<String, Object> attributes = customOAuth2User.getAttributes();

        if (userId == null) {
            String snsId = (String) attributes.get("snsId");
            String joinPath = (String) attributes.get("joinPath");
        }else {
            String accessToken = (String) attributes.get("accessToken");
        }

    }

}
