package Projects;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        String s="acccdddaaabbbbb";
        TextCompression tc=new TextCompression(s);
        String s1=tc.encode(s);
        System.out.println(s1);
        String s2=tc.decode(s1);
        System.out.println(s2);
	}

}
