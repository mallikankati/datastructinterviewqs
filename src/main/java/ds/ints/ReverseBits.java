package ds.ints;

public class ReverseBits {

	public static int reverseBits1(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				res = (res << 1) + 1;
			} else {
				res = res << 1;
			}
			n = n >> 1;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits1(0x555555) + ", Integer.reverse:"
				+ Integer.reverse(0x555555));
		System.out.println("(Integer.MAX_VALUE/0x55555555) :" + (float)(Integer.MAX_VALUE/0x55555555));
		System.out.println("(Integer.MAX_VALUE/0x33333333) :" + (float)(Integer.MAX_VALUE/0x33333333));
		System.out.println("(Integer.MAX_VALUE/0x0f0f0f0f) :" + (float)(Integer.MAX_VALUE/0x0f0f0f0f));
	}
}
