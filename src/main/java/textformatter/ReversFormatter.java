package textformatter;

public class ReversFormatter implements Formatter{
    @Override
    public String format(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
