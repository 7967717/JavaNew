
class AsciiCharSequence implements CharSequence {
    byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array.clone();
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] bytes = new byte[end - start];
        if (end - start >= 0) {
            System.arraycopy(array, start, bytes, 0, end - start);
        }
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append((char) b);
        }
        return sb.toString();
    }
}