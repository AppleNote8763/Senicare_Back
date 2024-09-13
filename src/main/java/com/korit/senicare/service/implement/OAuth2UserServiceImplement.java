package com.korit.senicare.service.implement;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(request);
        String registration = request.getClientRegistration().getClientName().toLowerCase();

        try {
            System.out.println("=========================================================================");
            System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
            System.out.println(oAuth2User.getName());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        String snsId = null;

        return oAuth2User;

    }

}
