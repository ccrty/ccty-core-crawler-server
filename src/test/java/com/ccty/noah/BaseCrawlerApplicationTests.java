package com.ccty.noah;

import com.ccty.noah.util.PageHtml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseCrawlerApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(PageHtml.getPageHtml("https://www.mafengwo.cn/"));
    }

}
