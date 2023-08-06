package com.epicode.gestioneDispositivi.security.service;

import com.epicode.gestioneDispositivi.security.payload.LoginDto;
import com.epicode.gestioneDispositivi.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
