public class LinearEquation {
    //instance variable
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    //constructor
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    //distance formula
    public double distance(){
        return Math.round(Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2))*100.0)/100.0;
    }
    //slope formula
    public double slope(){
        return Math.round(((double)(y2-y1)/(x2-x1))*100.0)/100.0;
    }
    //plug in x1 and y1 into y=mx+b to find b
    public double yIntercept(){
        return Math.round((y1-slope()*x1)*100.0)/100.0;
    }
    public String equation() {
        String slope;
        String yInterceptSign;
        //conditions for slope in equation
        String yIntercept = yIntercept() + "";  //this is used to access -b
        if (slope() != 1 && slope() != -1) {    //checking if the slope is not -1 or 1; if it is, equation will be returned as y=-x+b or y=x+b
            if (Math.round(slope()) == slope()) {   //checking if slope is an integer
                slope = (int) slope() + "";
            } else {    //if slope is not an integer, turn the slope into a fraction and check the signs of the y and x values to prevent something like 2/-5x from printing
                if (y2 - y1 < 0 && x2 - x1 < 0) {       //prevents -y/-x from printing ex: -6/-4x
                    slope = (Math.abs(y2 - y1)) + "/" + (Math.abs(x2 - x1));
                } else if (y2 - y1 > 0 && x2 - x1 < 0) {    //prevents y/-x from printing ex: 6/-4x
                    slope = "-" + (y2 - y1) + "/" + (Math.abs(x2 - x1));
                }else{      //otherwise, print the regular slope, but as a fraction because -y/x and y/x is okay
                    slope=(y2-y1)+"/"+(x2-x1);
                }


            }
        }

         else if (slope() == -1) {  //if slope is negative 1, set slope to "-" so y=-1x+b isn't printed
            slope = "-";
        } else {        //if all conditions don't meet, return "" so there is no sign or number in front of x
            slope = "";
        }
        //conditions for y-intercept in equation
         if (yIntercept() != 0) {       //checking if the slope isn't 0
            if (yIntercept() > 0) { //if y-intercept is positive, add "+" in front of it
                yInterceptSign = "+";
            } else {        //otherwise, if it is negative, don't add another sign in front of the y-intercept
                yInterceptSign = "";
            }
        }else{  //if y-intercept is 0, set the sign and y-intercept to "" so the equation will be returned as y=mx
            yInterceptSign="";
            yIntercept="";
        }
            return "y=" + slope + "x" + yInterceptSign + yIntercept;


    }
    //returns information regarding the line formed by the two points
    public String lineInfo(){
        String coord1="("+x1+","+y1+")";
        String coord2="("+x2+","+y2+")";
        return"\nThe two points are: "+coord1+" and "+coord2+"\nThe equation of the line between these points is: "+equation()+"\nThe slope of this line is: "+slope()+"\nthe y-intercept of the line is: "+yIntercept()+"\nThe distance between the two points is: "+distance();
    }
}
