
/**
 * Fast Java IO
 *
 */
public class Main {
 
	public static void main(String[] args) throws Exception {
 
		final int BUFFER_SIZE = 65536;
		final java.io.InputStream in = System.in;
 
		final byte[] buff = new byte[BUFFER_SIZE];
		int bytesRead = in.read(buff);
 
		byte c = 0;
		int sp = 0;
 
		int tests = 0;
		for (;;) {
			if ((c = buff[sp++]) == 32)
				break;
			tests = (10 * tests) + c - 48;
		}
 
		int k = 0;
		for (;;) {
			if ((c = buff[sp++]) == '\n')
				break;
			k = (10 * k) + c - 48;
		}
 
		long n = 0, count = 0;
		int testDone = 0;
 
		while (testDone < tests) {
 
			while (sp < bytesRead) {
 
				if ((c = buff[sp++]) == '\n') {
					if ((n / k) * k == n)
						++count;
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
 
		System.out.println(count);
 
	}
}