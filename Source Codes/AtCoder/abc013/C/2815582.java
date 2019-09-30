import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, H, A, B, C, D, E;
		N = sc.nextInt();
		H = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		E = sc.nextInt();
		calc(N, H, A, B, C, D, E);
		sc.close();
	}

	/**
	 * ?????????????????
	 * @param a ?????
	 * @param b ???
	 * @return a/b????????
	 */
	private static long ceil(long a, long b) {
		return (a + b - 1) / b;
	}
	private static void calc(int N, int H, int A, int B, int C, int D, int E){

		long min = (long)N * A; // ??????????
		for (int i = 0;i < N;++i) { // i???????????
			long eatSmall = Math.max(0, ceil((long)(N - i) * E - H - (long)i * B + 1, D + E));
			if (eatSmall > N - i) continue; // ??????????
			/*
			 * ???????????j?????H + i * B + j * D - (N - i - j) * E > 0
			 * ????H + i * B - (N - i) * E + j * D + j * E > 0
			 * ????(H + i * B - (N - i) * E) / (D + E) > j
			 * ????((N - i) * E - H - i * B) / (D + E) < j
			 * ?????????????????????
			 */
			min = Math.min(min, (long)i * A + eatSmall * C); // ????????????
		}
		System.out.println(min);
	}
}