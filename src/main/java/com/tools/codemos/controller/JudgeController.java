package com.tools.codemos.controller;

import com.tools.codemos.dto.JudgeCodeDTO;
import com.tools.codemos.dto.JudgeResultResponseDTO;
import com.tools.codemos.dto.LeaderBoardRequest;
import com.tools.codemos.dto.MypageResponseDTO;
import com.tools.codemos.jwt.TokenProvider;
import com.tools.codemos.model.LeaderBoardEntity;
import com.tools.codemos.service.JudgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/judge")
@RequiredArgsConstructor
public class JudgeController {

    private final TokenProvider tokenProvider;
    private final JudgeService judgeService;

    @PostMapping("/submit")
    public ResponseEntity<JudgeResultResponseDTO> submit(@RequestBody JudgeCodeDTO requestDto) {//,
                                                         //@RequestHeader(value = "Authorization") String token) {
//        token = token.substring(7);
//        String username = tokenProvider.getUsernameFromToken(token); // 사용자 검증

        JudgeResultResponseDTO responseDTO = judgeService.judgeCode(requestDto.getCode());
        System.out.println("responseDTO = " + responseDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
