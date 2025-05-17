package textformatter;

public class LowercaseFormatter implements Formatter{
    @Override
    public String format(String input) {
        return input.toLowerCase();
    }
}
