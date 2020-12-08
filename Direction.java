public class Direction {

    private int dir; //0 = north, 1=east, 2=south, 3=west

    public Direction() {
        this.dir = 0;
    }

    public Direction(int dir) {
        this.dir = dir;
    }

    /**
     *
     * @return vilken dirr bilen pekar
     */
    public int getDir() {
        return dir;
    }

    /**
     *
     * @param dir sätter direction
     */
    public void setDir(int dir) {
        this.dir = dir;
    }

    /**
     * Svänger vänster
     */
    public void turnLeft() {
        if (dir == 0) {
            dir = 3;
        } else dir -= 1;
    }

    /**
     *  Svänger höger
     */
    public void turnRight() {
        if (dir == 3) {
            dir = 0;
        } else dir += 1;
    }

    /**
     * Vänder bilen om
     */
    public void turnAround(){
        if(dir < 1 )
            dir += 2;
        else if(dir == 2)
            dir = 0;
        else if(dir == 3)
            dir = 1;
    }

}
