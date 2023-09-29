package com.epicode.HotelHaven.security.service;

import com.epicode.HotelHaven.security.payload.LoginDto;
import com.epicode.HotelHaven.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
