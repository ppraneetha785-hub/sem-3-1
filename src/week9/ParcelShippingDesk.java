package week9;
import java.util.*;

abstract class Parcel{

    double weight,value;

    Parcel(double weight,double value){
        this.weight=weight;
        this.value=value;
    }

    abstract double shippingCharge();

    double insurance(){
        return 0;
    }

    double total(){
        return shippingCharge()+insurance();
    }
}

class StandardParcel extends Parcel{

    StandardParcel(double w,double v){
        super(w,v);
    }

    double shippingCharge(){
        return 40+(10*weight);
    }
}

class ExpressParcel extends Parcel{

    ExpressParcel(double w,double v){
        super(w,v);
    }

    double shippingCharge(){
        return 80+(15*weight);
    }

    double insurance(){
        return value*0.02;
    }
}

class FragileParcel extends Parcel{

    FragileParcel(double w,double v){
        super(w,v);
    }

    double shippingCharge(){
        return 40+(10*weight)+50;
    }

    double insurance(){
        return value*0.02;
    }
}

public class ParcelShippingDesk{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        double grand=0;

        for(int i=0;i<n;i++){

            String type=sc.next();
            double w=sc.nextDouble();
            double v=sc.nextDouble();

            Parcel p;

            if(type.equals("STANDARD"))
                p=new StandardParcel(w,v);
            else if(type.equals("EXPRESS"))
                p=new ExpressParcel(w,v);
            else
                p=new FragileParcel(w,v);

            double charge=p.shippingCharge();
            double insurance=p.insurance();
            double total=p.total();

            grand+=total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type,charge,insurance,total);
        }

        System.out.printf("Grand Total: %.2f",grand);
    }
}