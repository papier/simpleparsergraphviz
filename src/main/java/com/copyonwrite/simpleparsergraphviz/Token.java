package com.copyonwrite.simpleparsergraphviz;

/**
 *
 * @author wolf
 */
public class Token {
    public final TokenType type;
    public final String value;
    
    private Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }
    
    public static Token create(TokenType type, String value) {
        return new Token(type, value);
    }
}
