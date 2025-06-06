package com.wap.app2.gachitayo.controller.auth;

import com.wap.app2.gachitayo.dto.request.LoginRequestDto;
import com.wap.app2.gachitayo.dto.request.RegisterRequestDto;
import com.wap.app2.gachitayo.dto.request.ReissueReqeuestDto;
import com.wap.app2.gachitayo.dto.response.TokenResponseDto;
import com.wap.app2.gachitayo.service.auth.GoogleAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/oauth")
@RequiredArgsConstructor
@RestController
@Controller
public class GoogleAuthController {
    private final GoogleAuthService googleAuthService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> userLogin(@RequestBody LoginRequestDto requestDto) {
        return googleAuthService.userLogin(requestDto);
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDto> userRegister(@RequestBody RegisterRequestDto requestDto) {
        return googleAuthService.registerUser(requestDto);
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenResponseDto> reissue(@RequestBody ReissueReqeuestDto requestDto) {
        return googleAuthService.reissueToken(requestDto);
    }
}
