public class Rectangle {
    private int x; // x coordinate of top left corner of the Rectangle
    private int y; // y coordinate of the top left corner of the Rectangle
    private int width; // The width of the rectangle
    private int height; // The height of the rectangle
    
    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(){
        this(0, 0, 0, 0);
    }
    
    public int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }
    
    int getWidth(){
        return width;
    }
    
    int getHeight(){
        return height;
    }
    
    public void setRect(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setRect(Rectangle other){
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.height = other.height;
    }
    
    public void translate(int deltaX, int deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }
    
    /**
     * Returns a new Rectangle object representing the intersection of this 
     * Rectangle with the specified Rectangle.
     * @param r the Rectangle to be intersected with this Rectangle
     * @return the largest Rectangle contained in both the specified Rectangle
     * and in this Rectangle.
     */
    public Rectangle createIntersection(Rectangle r){
        int rect1_TLx = x;
        int rect1_TLy = y;
        int rect1_BRx = x + width;
        int rect1_BRy = y + height;

        int rect2_TLx = r.x;
        int rect2_TLy = r.y;
        int rect2_BRx = r.x + r.width;
        int rect2_BRy = r.y + r.height;
        
        int rect3_TLx = Math.max(rect1_TLx, rect2_TLx);
        int rect3_TLy = Math.max(rect1_TLy, rect2_TLy);
        int rect3_BRx = Math.min(rect1_BRx, rect2_BRx);
        int rect3_BRy = Math.min(rect1_BRy, rect2_BRy);
        
        
        int rect3Width = rect3_BRx - rect3_TLx;
        int rect3Height = rect3_BRy - rect3_TLy;
        
        if(rect3Width <= 0 || rect3Height <= 0){
            return new Rectangle(0,0,0,0);
        } else {
            return new Rectangle(rect3_TLx, rect3_TLy, rect3Width, rect3Height);
        }   
    }
    
    public boolean intersects(Rectangle r){
        Rectangle r2 = this.createIntersection(r);
        return !(r2.x == 0 && r2.y == 0 && r2.width == 0 && r2.height == 0);
    }
    
    public int area(){
        return width * height;
    }

    public int perimeter(){
        return width * 2 + height * 2;
    }
    
    public String toString(){
        String s = "";
        s += this.getClass().getName();
        s +=   "[x=" + x + ",y=" + y + ",w=" + width + ",h=" + height + "]";
        return s;

    }
}