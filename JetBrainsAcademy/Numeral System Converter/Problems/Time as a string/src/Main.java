class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        String hh = hours < 10 ? "0" + hours : String.valueOf(hours);
        String mm = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        String ss = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
        return hh + ":" + mm + ":" + ss;
    }
}