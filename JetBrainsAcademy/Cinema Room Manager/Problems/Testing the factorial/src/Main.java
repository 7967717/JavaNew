public long get(int x) {
    // implement me
        if(x < 0){
            return -1;
        } else if( x == 0 || x == 1) {
            return 1;
        } else{
            return x * get(x - 1);
        }
}