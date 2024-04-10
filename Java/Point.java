public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        // reflexive
        if(other == this)
            return true;
        // non-null
        if(other == null)
            return false;
        // don't even bother! they have different types
        if(getClass() != other.getClass())
            return false;
        Point point = (Point) other; // why do we need this type cast?
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode(){
        int varCodeX = x;
        int varCodeY = y;
        // inits hash with the var code for one of the fields
        int hash = varCodeX;
        //  hash = <prime number> * hash + var_code;
        hash = 41 * hash + varCodeY;
        return hash;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

}
