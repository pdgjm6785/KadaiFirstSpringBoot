package com.kadaifsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class DayOfWeekApplication {

    public static void main(String[] args) {
        SpringApplication.run(DayOfWeekApplication.class, args);
    }
}

@RestController
class DayOfWeekController {
    // 仕様1：指定日の曜日を算定する,
    @GetMapping("/dayofweek/{date}")
    public String getDayOfWeek(@PathVariable String date) {
        return dispDayOfWeek(date);
    }

    private String dispDayOfWeek(String dateStr) {
        try {
            // 指定日の文字列をLocalDateオブジェクトに変換
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate localDate = LocalDate.parse(dateStr, formatter);

            // 曜日を取得して返す
            return localDate.getDayOfWeek().toString();
        } catch (Exception e) {
            return "Error occurred: " + e.getMessage();
        }
    }
    //仕様2：四則演算を行なう
    // ーーーーーー足し算ーーーーーー
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }
    // ーーーーーー足し算ここまでーーーーーー
    // ーーーーーー引き算ーーーーーー
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }
    // ーーーーーー引き算ここまでーーーーーー
    // ーーーーーー掛け算ーーーーーー
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }
    // ーーーーーー掛け算ここまでーーーーーー
    // ーーーーーー割り算ーーーーーー
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDvide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }
    // ーーーーーー割り算ここまでーーーーーー
}