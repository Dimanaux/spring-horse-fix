package com.example.fixhorse.services;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
    public int calculate(int width, int height, String start, String end) {
        HorseBoardFacade facade = new HorseBoardFacade(width, height);
        return facade.from(start).to(end).stepCount();
    }
}
