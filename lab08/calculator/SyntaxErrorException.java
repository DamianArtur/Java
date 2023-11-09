package calculator;

public class SyntaxErrorException extends Exception {

    String msg;

    public SyntaxErrorException(String msg) {super(); this.msg = msg;}

    @Override
    public String toString() {
        return msg;
    }
}
