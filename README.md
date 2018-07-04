# simpleparsergraphviz
Simple LL(0) parser which emits DOT commands to visualize the AST.

The parser understands this language:

    expression := factor [('+' | '-') expression]
    factor := atom [('*' | '/') factor]
    atom := 1-9[0-9]*

The whole point of this project is generating a sample description of a diagram in DOT which can be visualized with [Graphviz](https://www.graphviz.org/).
