package com.copyonwrite.simpleparsergraphviz;

import java.util.Optional;

/**
 *
 * @author wolf
 */
interface TokenProvider {
    void consume();
    Optional<Token> current();
}
