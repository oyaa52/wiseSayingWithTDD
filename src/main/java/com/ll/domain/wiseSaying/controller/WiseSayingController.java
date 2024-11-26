package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private int lastId;
    private final Scanner scanner;
    private List<WiseSaying> wiseSayingsList;

    public WiseSayingController(Scanner scanner) {
        this.lastId = 0;
        this.scanner = scanner;
        this.wiseSayingsList = new ArrayList<>();
    }

    public void actionAdd() {
        System.out.println("명언: ");
        String quotes = scanner.nextLine();
        System.out.println("작가: ");
        String author = scanner.nextLine();

        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, quotes, author);
        wiseSayingsList.add(wiseSaying);

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 | 작가 | 명언");
        System.out.println("---------------------------");
        for (WiseSaying wiseSaying : wiseSayingsList.reversed()) {
            System.out.println(wiseSaying.getId() + " | " + wiseSaying.getAuthor() + " | " + wiseSaying.getQuotes());
        }
    }
}
