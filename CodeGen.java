import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.awt.*;	
import java.awt.event.*;	
import javax.swing.*;	
import java.util.*;	
import java.io.*;	
import java.text.*;	
import java.util.regex.*;
 
public class CodeGen
{
     static PrintStream o;   
     static {
     try {
           o = new PrintStream(new File("C://Users//hanuc//OneDrive//Desktop//PlChome//testFile1.txt"));
      }    catch (final IOException e) {
           throw new ExceptionInInitializerError(e.getMessage());
     }
    }
 
    

    
    public static void main(String[] args) throws IOException
    {
         System.setOut(o);
         System.out.println("int main() {");
         stat();
         System.out.println(" ");
         System.out.println("\nreturn 0;");
         System.out.println("}");
        
    }

public static double rand_gen()
{
   Random rand = new Random();
   double n = rand.nextInt(100) + 1;
   n=n/100;
   return n;
}

public static void stat()
{
  System.setOut(o);
  //System.out.println("Written from method");
  //System.out.println(rand_gen());

  decl_stat();
  System.out.println("");
 // assgn_stat();
  double x=rand_gen();
        if(x>0 && x<= 0.15) 
	if_stat();
	else if(x>0.15 && x<=0.3) 
	iter_stat(); 
	else if(x>0.3 && x<=0.45)
	assgn_stat(); 
	else if(x>0.45 && x<=0.6) 
	decl_stat();
	else if(x>0.6 && x<=1)
	stat();

        System.out.println("");
} 

public static void if_stat() 
{
   System.setOut(o);
   double x=rand_gen();
   System.out.print("if(");
   exp();
   System.out.println(")");
   if(x>0 && x<=0.5) {
   stat(); }
   
   else if(x>0.5 && x<=1) {
   stat();
   System.out.println("");
   System.out.print("else ");
   stat(); }
   
}

public static void iter_stat() 
{
   System.setOut(o);
   double x=rand_gen();
   System.out.println(" ");
   System.out.print("while(");
   exp();
   System.out.println(")");
   stat();
}

public static void assgn_stat()
{
   System.setOut(o);
   id();
   System.out.print("=");
   exp();
   
   
   
}

public static void decl_stat()
{
   type();
   System.setOut(o);
   double x=rand_gen();
   System.out.print(" ");
   if(x>0 && x<=0.7) {
	 id();
         System.out.println(";");
    }
   
   else if(x>0.7)
    {
    	assgn_stat();
        System.out.println(";");
    }
  
  //System.out.println(";");
      
}

public static void exp()
{
   double x=rand_gen();
   if(x>0 && x<=0.5)
	{
		id();
		op();
		constant();
	}
   
   else if(x>0.5 && x<=1)
	{
		constant();
		op();
		id();
	}
 //System.out.println(";");
}

public static void op()
{
   System.setOut(o);
   double x=rand_gen();
  
        if(x>0 && x<=0.25)
	System.out.print("+");
	else if(x>0.25 && x<=0.5)
	System.out.print("-");
	else if(x>0.5 && x<=0.75)
	System.out.print("*");
	else if(x>0.75)
	System.out.print("/");   
}

public static void type()
{
   System.setOut(o);
   double x=rand_gen();
   if(x>0 && x<=0.5)
	System.out.print("int ");
	else
	System.out.print("double ");
}

public static void id()
{
   System.setOut(o);
   double x=rand_gen();
   double z=rand_gen();
   z=z*100;
   Random rand = new Random();
   double n1 = rand.nextInt(26) + 97;
   char asci1=(char)n1;
   double n2 = rand.nextInt(26) + 97;
   char asci2=(char)n2;
   
   if(x>0 && x<=0.33)
   {
      System.out.print(asci1);
      System.out.print(asci2); 
   }

   if(x>0.33 && x<=0.66)
   {
      System.out.print(asci1);
      //System.out.print(z); 
   }
  
   if(x>0.66 && x<=1)
   {
      System.out.print(asci1);
      //System.out.print(z); 
      System.out.print(asci1);
   }
   // System.out.println(";");
   
}

public static void constant()
{
   System.setOut(o);
   double x=rand_gen();
   x=x*10;
   long l=(long)x;
   int i=(int)l;
   for(int z=0;z<i;z++) {
   double x1=rand_gen();
   x1=x1*10;
   long l1=(long)x1;
   int i1=(int)l1;
   System.out.print(i1);}
}

}