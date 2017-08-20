package p1;

public class Methods {
	public static void main(String args[]){
		
		int a=10;
		int b=20;
		int c=30;

		 System.out.println("addition of two symbols  " +c);
		 c=sum(a,b);
		 
		 System.out.println("subtraction of two variables  " +c);
		 c=sub(a,b);
		 
		 System.out.println("multiplication of two numbers  "+c);
	     c=mul(a,b);
		
	}

    public static int sum(int a, int b){
    	
         int c=a+b;   	
    	 return c;    	
    }
    
    public static int sub(int a, int b){
    	
          int c=a-b;   	
   	      return c;    	
   }
    public static int mul(int a, int b){
    	
          int c=a*b;   	
   	      return c;    	
   }
    
    
    
}