public class Main {

	public static void main(String[] args) throws Exception{

		int a =0;
		int ans = 0;
	
		final int BUFFER_SIZE = 1024;
		final java.io.InputStream in = System.in;
 
		final byte[] buff = new byte[BUFFER_SIZE];
		int bytesRead = in.read(buff);
 
		byte c = 0;
		int sp = 0;
 
		int tests = 0;
		//read number of elts
		for (;;) {
			if ((c = buff[sp++]) == '\n')
				break;
			tests = (10 * tests) + c - 48;
		}
 
		int n = 0;
		int testDone = 0;
 
		//loop
		while (testDone < tests) {
 
			while (sp < bytesRead) {
 
				if ((c = buff[sp++]) == '\n') {
					//calc here
					ans = a^n;
					a =ans;
					++testDone;
					n ^= n;
				} else {
					n = n * 10 + c - 48;
				}
			}
			if (sp >= BUFFER_SIZE) {
				bytesRead = in.read(buff);
				if (bytesRead == -1) {
					break;
				}
				sp ^= sp;
			}
		}
 
		System.out.println(ans);
	}

}
