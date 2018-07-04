package com.copyonwrite.simpleparsergraphviz;

import java.util.Optional;

/**
 *
 * @author wolf
 */
public class ASTNode {

    static ASTNode create(Token create) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public final Token token;
    public final Optional<ASTNode> left;
    public final Optional<ASTNode> right;

    private ASTNode(Token token, Optional<ASTNode> left, Optional<ASTNode> right) {
        this.token = token;
        this.left = left;
        this.right = right;
    }
    
    public static ASTNode create(Token token, Optional<ASTNode> left, Optional<ASTNode> right) {
        return new ASTNode(token, left, right);
    }
}
