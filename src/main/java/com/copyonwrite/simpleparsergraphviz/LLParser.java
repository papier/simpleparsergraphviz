package com.copyonwrite.simpleparsergraphviz;

import java.util.Optional;

/**
 *
 * @author wolf
 */
public class LLParser {
    private final TokenProvider tokenProvider;

    private LLParser(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }
    
    public static LLParser create(TokenProvider tokenProvider) {
        return new LLParser(tokenProvider);
    } 
    
    public ASTNode parse() {
        Optional<Token> current = this.tokenProvider.current();
        
        if (current.isPresent() && current.get().type == TokenType.OPERAND) {
            return expression();
        } else {
            return ASTNode.create(Token.create(TokenType.EOS,""), Optional.empty(), Optional.empty());
        }
    }

    private ASTNode expression() {
        final ASTNode left = factor();
        if (isAdditionOrSubtraction()) {
            final Token operator = tokenProvider.current().get();
            tokenProvider.consume();
            return ASTNode.create(operator, Optional.of(left), Optional.of(expression())); 
        }
        return left;
    }

    private ASTNode factor() {
        final ASTNode left = atom();
        if (isMultiplicationOrDivision()) {
            final Token operator = tokenProvider.current().get();
            tokenProvider.consume();
            return ASTNode.create(operator, Optional.of(left), Optional.of(factor())); 
        }
        return left;
    }

    private ASTNode atom() {
        Token current = tokenProvider.current().get();
        tokenProvider.consume();
        return ASTNode.create(current, Optional.empty(), Optional.empty());
    }

    private boolean isMultiplicationOrDivision() {
        if (tokenProvider.current().isPresent()) {
            Token current = tokenProvider.current().get();
            return current.type == TokenType.OPERATOR && (current.value.equals("*") || current.value.equals("/")); 
        }
        return false;
    }
    
    private boolean isAdditionOrSubtraction() {
        if (tokenProvider.current().isPresent()) {
            Token current = tokenProvider.current().get();
            return current.type == TokenType.OPERATOR && (current.value.equals("+") || current.value.equals("-")); 
        }
        return false;
    }
}
