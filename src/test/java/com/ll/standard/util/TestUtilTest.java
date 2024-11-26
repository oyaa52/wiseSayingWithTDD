package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestUtilTest {
    @Test
    @DisplayName("TestUtil.getScanner()")
    public void t1() {
        Scanner scanner = TestUtil.getScanner("""
                등록
                나의 죽음을 적에게 알리지 마라
                이순신 장군
                """.stripIndent().trim());

        String cmd = scanner.nextLine();
        String quotes = scanner.nextLine();
        String author = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(quotes).isEqualTo("나의 죽음을 적에게 알리지 마라");
        assertThat(author).isEqualTo("이순신 장군");
    }

    @Test
    @DisplayName("TestUtil.setOutToByteArray()")
    public void t2() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        System.out.println("2 | 이순신 | 나의 죽음을 적에게 알리지 말라");

        String out = output.toString().trim();
        TestUtil.setOutToByteArray();

        assertThat(out).isEqualTo("2 | 이순신 | 나의 죽음을 적에게 알리지 말라");
        System.out.println("이제는 화면에 출력됩니다.");
    }
}
