class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        minutes++;
        if (minutes == 60 && hours == 12) {
            minutes = 0;
            hours = 1;
        } else if (minutes == 60) {
            minutes = 0;
            hours++;
        }
    }
}

