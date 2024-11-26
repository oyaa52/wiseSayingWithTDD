package com.ll;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {
    @Test
    @DisplayName("1단계 : == 명언 앱 == 출력")
    public void t1() {
        String output = AppTest.run("");

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("1단계 : 명령) 출력")
    public void t2() {
        String output = AppTest.run("""
                목록
                """);

        assertThat(output).contains("명령) ");
    }

    @Test
    @DisplayName("2단계 : 명령을 종료 전까지 계속 나오게 한다")
    public void t3() {
        String output = AppTest.run("""
                목록
                목록
                """);
        String[] split = output.split("명령\\)");
        assertThat(split).hasSize(4);
    }

    public static String run(String input) {
        input = input.stripIndent().trim() + "\n종료";
        Scanner scanner = TestUtil.getScanner(input);
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        App app = new App(scanner);
        app.run();

        String output = outputStream.toString();

        TestUtil.clearSetOutToByteArray(outputStream);

        return output;
    }
}