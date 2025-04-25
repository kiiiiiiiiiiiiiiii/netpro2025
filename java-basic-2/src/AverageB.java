import java.util.Arrays;
import java.util.Random;

public class AverageB {
	public static final int N=100;
	Subject[] subject = new Subject[N];
	static String kamokuname="数学";
    private String subject_name;

	public static void main(String[] args) {
		AverageB average_b= new AverageB(kamokuname);
		average_b.initalizeScores();
		average_b.printAverage();
		average_b.isSuccessful();

	}
	
	AverageB(String s){
		this.subject_name=s;

	}
	void initalizeScores(){
		Random r = new Random();

		for(int i=0;i<N;i++){
			int score = r.nextInt(N+1);
			subject[i]= new Subject(score);
		}
	}
	
	void printAverage(){
		int sum=0;
		for(int i=0;i<N;i++){
			sum+=subject[i].getScore();
		}
		System.out.println("平均点は"+sum/N);
	}

	void isSuccessful(){
        
	}//student idと点数をソートしてだせ。＞＝８０以上
}