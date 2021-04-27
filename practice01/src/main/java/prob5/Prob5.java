package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		
		for(int i=1;i<=99;i++) {
			String num=Integer.toString(i);
			int count=0;
			
			for(int j=0;j<num.length();j++) {
				if(num.substring(j,j+1).equals("3") || num.substring(j,j+1).equals("6") || num.substring(j,j+1).equals("9")) {
					count+=1;
				}
			}
			
			switch (count) {
			case 0:
				break;
			case 1:
				System.out.println(i+" 짝");
				break;
			case 2:
				System.out.println(i+" 짝짝");
				break;
			}
				
			
		}
		
		
		
	}
}
