package com.copyonwrite.simpleparsergraphviz;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author wolf
 */
public class TokensFromList implements TokenProvider {
    private final List<Token> tokenStream;
    private int position;

    public TokensFromList(List<Token> tokenStream) {
        this.tokenStream = tokenStream;
    }
    
    @Override
    public void consume() {
        if (position < tokenStream.size()) {
            position++;
        }
    }

    @Override
    public Optional<Token> current() {
        if (position < tokenStream.size()) {
            return Optional.of(tokenStream.get(position));
        }
        return Optional.empty();
    }
}
