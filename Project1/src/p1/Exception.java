package p1;

public class Exception {
	public static void main(String args[]){
		
		int[] nums= new int[7];
		
		try{
		    
			System.out.println("before exception is generated");
			
			nums[4]=7;
			
			System.out.println("this won't be displayed");
			
		}
		
		catch(ArrayIndexOutOfBoundsException exc){
			
			System.out.println("index out of boounds");
		}
		
		System.out.println(" After catch");
	}

}
