package com.batch2.onlineshopping.controller;

import java.util.ArrayList;


import com.batch2.onlineshopping.config.JwtUtils;
import com.batch2.onlineshopping.entity.LoginRequest;
import com.batch2.onlineshopping.entity.LoginResponse;
import com.batch2.onlineshopping.service.JpaUserDetailsService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
    private JpaUserDetailsService userDetailsService;


	@Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request, HttpServletResponse response) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(),
                            new ArrayList<>()));
            final UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);
                Cookie cookie = new Cookie("jwt", jwt);
                cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                cookie.setPath("/"); // Global
                response.addCookie(cookie);
                return ResponseEntity.ok(new LoginResponse(request.getUsername(), jwt));
            }
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
	
}
