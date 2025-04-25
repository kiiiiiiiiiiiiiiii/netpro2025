public class MyExceptionTest {
    public static void main(String[] args) {
        MyExceptionTest myE = new MyExceptionTest();

        try {
            myE.test();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    void test() throws MyException{//throws MyExceptionが大事
		if(true){
			throw new MyException();
		}
	}
}