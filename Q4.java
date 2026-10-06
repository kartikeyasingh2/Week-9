import java.util.*;
abstract class Cab{
double km;
Cab(double km){this.km=km;}
abstract double rate();
double fare(){return Math.max(100,km*rate());}
}
interface NightService{
double nightFare(double fare);
}
class Mini extends Cab{
Mini(double km){super(km);}
double rate(){return 10;}
}
class Sedan extends Cab implements NightService{
Sedan(double km){super(km);}
double rate(){return 14;}
public double nightFare(double fare){return fare*1.20;}
}
class SUV extends Cab implements NightService{
SUV(double km){super(km);}
double rate(){return 18;}
public double nightFare(double fare){return fare*1.20;}
}
public class Q4{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
double total=0;
for(int i=0;i<n;i++){
String type=sc.next();
double km=sc.nextDouble();
String time=sc.next();
Cab c;
if(type.equals("MINI"))c=new Mini(km);
else if(type.equals("SEDAN"))c=new Sedan(km);
else c=new SUV(km);
if(time.equals("NIGHT")&&!(c instanceof NightService)){
System.out.println(type+": night service not available");
continue;
}
double fare=c.fare();
if(time.equals("NIGHT"))fare=((NightService)c).nightFare(fare);
total+=fare;
System.out.printf("%s: %.2f%n",type,fare);
}
System.out.printf("Total: %.2f",total);
}
}