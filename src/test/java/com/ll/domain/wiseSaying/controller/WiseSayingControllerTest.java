package com.ll.domain.wiseSaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("2단계 : 등록 명령어를 입력하면 명언: , 작가: 출력하고 내용을 입력 받는다")
    public void t4() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                """);

        assertThat(output)
                .contains("명언: ")
                .contains("작가: ");
    }

    @Test
    @DisplayName("2단계 : 등록을 입력하면 명언: , 작가: 출력하고 내용을 입력 받는다")
    public void t5() {
        String output = AppTest.run("""
                등록
                ?
                !
                """);

        assertThat(output)
                .contains("명언: ")
                .contains("작가: ");
    }

//    @Test
//    @DisplayName("2단계 : 등록을 입력하면 명언: , 작가: 에서 내용을 입력 받는다")
//    public void t6() {
//        String input = """
//                등록
//                현재를 사랑하라
//                작자미상
//                """;
//
//        AppTest.run(input);
//
//        List<WiseSaying> wiseSayingsList = app.getController().getWiseSayingsList();
//
//        assertThat(wiseSayingsList).hasSize(1);
//        assertThat(wiseSayingsList.get(0).getQuotes()).isEqualTo("현재를 사랑하라");
//        assertThat(wiseSayingsList.get(0).getAuthor().isEqualTo("작자미상"));
//
////        String output = AppTest.run("""
////                등록
////                현재를 사랑하라
////                작자미상
////                """);
////
////        assertThat(output)
////                .contains("현재를 사랑하라")
////                .contains("작자미상");
//    }

    @Test
    @DisplayName("3단계 : 등록을 완료하면 \"id번 명언이 등록되었습니다.\"를 출력한다")
    public void t7() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                """);

        assertThat(output)
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("4단계 : 등록할 때마다 생성되는 명언번호는 1씩 증가한다")
    public void t8() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                현재를 사랑하라
                작자미상
                """);

        assertThat(output)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("4단계 : 등록할 때마다 생성되는 명언번호는 1씩 증가한다")
    public void t9() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                현재를 사랑하라
                작자미상
                등록
                현재를 사랑하라
                작자미상
                """);

        assertThat(output)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .contains("3번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("5단계 : 목록 명령어를 입력하면 이때까지 입력된 명언들을 출력한다")
    public void t10() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                과거에 집착하지 마라
                작자미상
                목록
                """);

        assertThat(output)
                .contains("번호 | 작가 | 명언")
                .contains("---------------------------")
                .contains("2 | 작자미상 | 과거에 집착하지 마라")
                .contains("1 | 작자미상 | 현재를 사랑하라");
    }

    @Test
    @DisplayName("5단계 : 목록 명령어를 입력하면 이때까지 입력된 명언들을 출력한다")
    public void t11() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                과거에 집착하지 마라
                작자미상
                등록
                나의 죽음을 적에게 알리지 말라!
                이순신 장군
                목록
                """);

        assertThat(output)
                .contains("번호 | 작가 | 명언")
                .contains("---------------------------")
                .contains("3 | 이순신 장군 | 나의 죽음을 적에게 알리지 말라!")
                .contains("2 | 작자미상 | 과거에 집착하지 마라")
                .contains("1 | 작자미상 | 현재를 사랑하라");
    }
}
