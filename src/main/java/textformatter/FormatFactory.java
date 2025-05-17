package textformatter;

public class FormatFactory {
    public static void getFormatter(String name) {
        return switch (name) {
            case "UppercaseFormatter" = new UppercaseFormatter();
            case "LowercaseFormatter" = new LowercaseFormatter();
            case "DashFormatter" = new DashFormatter();
            case "ReversFormatter" = new ReversFormatter();
            case "CamelCaseFormatter" = new CamelCaseFormatter();
                default -> throw new IllegalArgumentException("Unknown fomatter: " + name);
        };
    }

    public static String applyformatters(String input, Formatter[] formatters){
            String result = input;
            for (Formatter formatter : formatters) {
                result = formatter.format(result);
            }
        return result;
    }

}
