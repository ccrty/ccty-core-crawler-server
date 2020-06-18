package com.ccty.noah.base;

/**
 * 常用信息
 * @author 缄默
 * @date   2020/06/09
 */
public interface CrawlerInterface {

    /**
     * 文章来源
     */
    static enum ArticleSources{
        //去哪儿
        QUNAER(1,"去哪儿网"),
        //穷游
        QYER(2,"穷游网");
        private Integer code;
        private String name;

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        ArticleSources(Integer code, String name) {
            this.code = code;
            this.name = name;
        }


    }
}
