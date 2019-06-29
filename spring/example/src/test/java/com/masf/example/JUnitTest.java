package com.masf.example;

import com.masf.example.util.DateFormatUtil;
import org.junit.*;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class JUnitTest {

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("单元测试开始之前执行初始化......");
        System.out.println("------------------------------");
    }

    @Before
    public void beforeTest() {
        System.out.println("单元测试方法开始之前执行......");
    }

    @Test
    public void test1() {
        Date sd = DateFormatUtil.formatStr2Date("2017-05-16");
        Date ed = DateFormatUtil.formatStr2Date("2017-05-25");
        System.out.println("相差天数: " + DateFormatUtil.getBetweenDays(sd, ed));
        assertEquals("相差天数: ", 9, DateFormatUtil.getBetweenDays(sd, ed));
    }

    @Test
    public void test2() {
        Date sd = DateFormatUtil.formatStr2Date("2017-05-16");
        Date ed = DateFormatUtil.formatStr2Date("2017-09-30");
        System.out.println("相差天数: " + DateFormatUtil.getBetweenDays(sd, ed));
        assertEquals("相差天数: ", 9, DateFormatUtil.getBetweenDays(sd, ed));
    }

    @After
    public void afterTest() {
        System.out.println("单元测试方式结束之后执行......");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("------------------------");
        System.out.println("单元测试结束之后执行......");
    }
}
