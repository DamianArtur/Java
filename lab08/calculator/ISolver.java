public interface ISolver {
    /**
     *
     * return precedence of given operator
     */
    int getPrecedence(char character);

    /**
     *
     * convert expression in infix notation to RPN notation
     */
    String infixToRpn(String expression) throws SyntaxErrorException;

    /**
     *
     * evaluate given expression in RPN notation
     */
    String evaluate(String expression) throws SyntaxErrorException;

    /**
     *
     * main function that find a solution for given infix expression
     */
    String solve(String expression);
}
