package forttest;

public class FirstTestAidaPavel {

    double radius ;
    double h;
    double a;
    double p=3.14;

    public double circle( double p, double radius){
        double pl = 2*radius*p;
        this.radius=radius;
        this.p=p;
        return pl;
    }
    public double triangle(double a, double h){
        double  plTR = 0.5*(a*h);
        this.a= a;
        this.h= h;
        return plTR;
    }

    public boolean trueFalse(int chislo){
        if (chislo%2==0){
            System.out.println(true);
        }
        else if(chislo==2){
            System.out.println(false);
        }
        else {
            System.out.println(false);
        }
        return true;
    }

}
