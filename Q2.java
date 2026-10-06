import java.util.*;
abstract class Parcel{
double weight,value;
Parcel(double weight,double value){this.weight=weight;this.value=value;}
abstract double charge();
}
interface Insurable{
double insurance();
}
class Standard extends Parcel{
Standard(double weight,double value){super(weight,value);}
double charge(){return 40+10*weight;}
}
class Express extends Parcel implements Insurable{
Express(double weight,double value){super(weight,value);}
double charge(){return 80+15*weight;}
public double insurance(){return value*0.02;}
}
class Fragile extends Parcel implements Insurable{
Fragile(double weight,double value){super(weight,value);}
double charge(){return 40+10*weight+50;}
public double insurance(){return value*0.02;}
}
public class Q2{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
double grandTotal=0;
for(int i=0;i<n;i++){
String type=sc.next();
double weight=sc.nextDouble();
double value=sc.nextDouble();
Parcel p;
if(type.equals("STANDARD"))p=new Standard(weight,value);
else if(type.equals("EXPRESS"))p=new Express(weight,value);
else p=new Fragile(weight,value);
double charge=p.charge();
double insurance=p instanceof Insurable?((Insurable)p).insurance():0;
double total=charge+insurance;
grandTotal+=total;
System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",type,charge,insurance,total);
}
System.out.printf("Grand Total: %.2f",grandTotal);
}
}