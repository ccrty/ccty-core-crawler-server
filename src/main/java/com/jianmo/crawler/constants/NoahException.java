package com.jianmo.crawler.constants;

/**
 * @author 缄默
 * @date 2019/5/23
 */
public class NoahException extends RuntimeException {

    private static final long serialVersionUID = -3414443277824683844L;
    private int code;

    public NoahException(int code) {
        this.code = code;
    }

    public NoahException(int code, Object message) {
        super(message.toString());
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
