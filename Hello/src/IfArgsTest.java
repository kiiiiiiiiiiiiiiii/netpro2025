public class IfArgsTest {
    public static void main(String[] args) { 
		int x=Integer.parseInt(args[0]);
		/*以下を改造する。**/
        if (x < 0 || x > 9){
            System.out.println("out of scope");
        } else {
            if (x >= 7) {
                System.out.println(x+" is Big number");
            } else if (x >= 4) {
                System.out.println(x+" is middle Number");
            } else {
                System.out.println(x+" is small number");
            }
        }
	
	

	}//main end
}
