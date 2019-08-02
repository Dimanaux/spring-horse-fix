package com.example.fixhorse.web;

import com.example.fixhorse.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hourse/rest")
public class RestPresenter {
    private final BoardService boardService;

    @Autowired
    public RestPresenter(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/count", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Integer> count(@RequestParam Integer width,
                                         @RequestParam Integer height,
                                         @RequestParam String start,
                                         @RequestParam String end) {
        int answer = boardService.calculate(width, height, start, end);
        return ResponseEntity.ok(answer);
    }
}
