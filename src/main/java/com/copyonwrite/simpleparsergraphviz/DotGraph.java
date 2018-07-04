package com.copyonwrite.simpleparsergraphviz;

/**
 *
 * @author wolf
 */
class DotGraph {
    private final ASTNode ast;

    private DotGraph(ASTNode ast) {
        this.ast = ast;
    }
    
    public static DotGraph create(ASTNode ast) {
        return new DotGraph(ast);
    }

    @Override
    public String toString() {
        return build();
    }

    private String build() {
        final StringBuilder sb = new StringBuilder();
        sb.append("digraph {");
        sb.append("\n");
        sb.append(buildAttributes(ast));
        sb.append(buildGraph(ast));
        sb.append("}");
        sb.append("\n");
        return sb.toString();
    }

    private String buildGraph(ASTNode ast) {
        if (ast.token.type == TokenType.OPERATOR) {
            return String.format("  %10s -> %10s;%n  %10s -> %10s;%n",
                    ast.token.hashCode(), ast.left.get().token.hashCode(),
                    ast.token.hashCode(), ast.right.get().token.hashCode()
            ) + buildGraph(ast.left.get()) + buildGraph(ast.right.get());
        }
        return "";
    }

    private String buildAttributes(ASTNode ast) {
        return buildAttributesForNode(ast.token) + (ast.left.isPresent() ? buildAttributes(ast.left.get()) : "") 
          + (ast.right.isPresent() ? buildAttributes(ast.right.get()) : "");
    }

    private static String buildAttributesForNode(Token token) {
        if (token.type == TokenType.OPERATOR) {
            return String.format("  %10s [label=\"%2s\" color=red];%n", 
                    token.hashCode(), 
                    token.value
            );
        }
        return String.format("  %10s [label=\"%2s\" shape=box color=blue];%n", 
                token.hashCode(), 
                token.value
        );
    }
}
