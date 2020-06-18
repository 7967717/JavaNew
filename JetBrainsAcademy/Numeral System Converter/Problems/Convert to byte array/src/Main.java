import java.io.CharArrayWriter;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        for (String s : words) {
            writer.write(s);
        }
        return writer.toCharArray();
    }
}