package com.copyonwrite.simpleparsergraphviz;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String... args) {
    List<Token> tokenStream = Arrays.asList(new Token[] {
        Token.create(TokenType.OPERAND, "5"),
        Token.create(TokenType.OPERATOR, "+"),
        Token.create(TokenType.OPERAND, "15"),
        Token.create(TokenType.OPERATOR, "*"),
        Token.create(TokenType.OPERAND, "3"),
        Token.create(TokenType.OPERATOR, "+"),
        Token.create(TokenType.OPERAND, "7"),
        Token.create(TokenType.OPERATOR, "*"),
        Token.create(TokenType.OPERAND, "3"),
        Token.create(TokenType.OPERATOR, "/"),
        Token.create(TokenType.OPERAND, "4"),
        Token.create(TokenType.OPERATOR, "-"),
        Token.create(TokenType.OPERAND, "12"),
    });
    TokenProvider sampleTokens = new TokensFromList(tokenStream);
    System.out.println(DotGraph.create(LLParser.create(sampleTokens).parse()));
  }
}
