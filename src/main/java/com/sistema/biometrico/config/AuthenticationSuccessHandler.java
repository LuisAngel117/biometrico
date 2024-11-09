package com.sistema.biometrico.config;

import java.io.IOException;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority-> grantedAuthority.getAuthority().equals("ROLE_Admin"));
		boolean isUser = authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority-> grantedAuthority.getAuthority().equals("ROLE_Usuario"));
		if(isAdmin && isUser) {
			setDefaultTargetUrl("/admin/home");
		}else {
			setDefaultTargetUrl("/user/home");
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	

}
