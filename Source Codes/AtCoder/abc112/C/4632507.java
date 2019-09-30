import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}

	private void solve() throws IOException {
		try {
			//			solveA();
			//			solveB();
			//			solveC();
			solveC2();
			// solveD();
			// solveE();
			// solveF();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.flush();
				out.close();
			}
		}

	}

	private void solveA() {
		int age = 0;

		age = Integer.parseInt(next());
		switch (age) {
		case 1:
			out.println("Hello World");
			break;
		case 2:
			int numA = nextInt();
			int numB = nextInt();
			out.println(numA + numB);
			break;
		}

	}

	private void solveB() {
		int numN = Integer.parseInt(next());
		int numT = Integer.parseInt(next());

		int[][] wk = new int[numN][2];

		for (int i = 0; i < wk.length; i++) {
			for (int j = 0; j < 2; j++) {
				wk[i][j] = nextInt();
			}
		}

		Arrays.sort(wk, (x, y) -> Integer.compare(x[1], y[1]));

		int cnt = 9999999;
		for (int i = 0; i < wk.length; i++) {
			if (wk[i][1] <= numT) {
				cnt = Math.min(wk[i][0], cnt);
			} else {
				break;
			}
		}

		out.println(cnt != 9999999 ? cnt : "TLE");
	}

	private void solveC2() {

		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.next());
		int[] x = new int[N];
		int[] y = new int[N];
		long[] h = new long[N];
		for (int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(scan.next());
			y[i] = Integer.parseInt(scan.next());
			h[i] = Integer.parseInt(scan.next());
		}
		int Cx = -1;
		int Cy = -1;
		long candidateH = 0;
		boolean find = true;
		int candidateIndex = 0;
		while (h[candidateIndex] == 0) {
			candidateIndex++;
		}

		for (int i = 0; i <= 100; i++) {
			Cx = i;
			for (int j = 0; j <= 100; j++) {
				Cy = j;
				find = true;
				candidateH = h[candidateIndex] + Math.abs(Cx - x[candidateIndex]) + Math.abs(Cy - y[candidateIndex]);
				for (int k = 0; k < N; k++) {
					if (h[k] != Math.max(candidateH - Math.abs(Cx - x[k]) - Math.abs(Cy - y[k]), 0)) {
						find = false;
						break;
					}
				}
				if (find) {
					System.out.println(Cx + " " + Cy + " " + candidateH);
					return;
				}
			}
		}
	}

	private void solveC() {
		int numN = Integer.parseInt(next());

		long[][] wk = new long[numN][3];

		for (int i = 0; i < numN; i++) {
			for (int j = 0; j < 3; j++) {
				wk[i][j] = nextLong();
			}
		}

		long h = -1;
		for (long i = 0; i <= 100; i++) {
			for (long j = 0; j <= 100; j++) {
				boolean isRes = true;
				h = Math.max(Math.abs(wk[0][0] - i) + Math.abs(wk[0][1] - j) + wk[0][2], (long) 0);
				for (int k = 0; k < numN; k++) {
					if (wk[k][2] != Math.max(h - Math.abs(wk[k][0] - i) - Math.abs(wk[k][1] - j), (long) 0)) {
						isRes = false;
						break;
					}
				}
				if (isRes) {
					System.out.println(i + " " + j + " " + h);
					return;
				}
			}
		}

	}

	private void solveD() {
		int numN = Integer.parseInt(next());

		out.println("");
	}

	private void solveE() {
		int numN = Integer.parseInt(next());

		out.println("");
	}

	private void solveF() {
		int numN = Integer.parseInt(next());

		out.println("");
	}

	private final PrintWriter out = new PrintWriter(System.out);
	private final InputStream in = System.in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;

	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		} else {
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) {
				return false;
			}
		}
		return true;
	}

	private int readByte() {
		if (hasNextByte())
			return buffer[ptr++];
		else
			return -1;
	}

	private static boolean isPrintableChar(int c) {
		return 33 <= c && c <= 126;
	}

	private void skipUnprintable() {
		while (hasNextByte() && !isPrintableChar(buffer[ptr]))
			ptr++;
	}

	public boolean hasNext() {
		skipUnprintable();
		return hasNextByte();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public long nextLong() {
		if (!hasNext())
			throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
		while (true) {
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			} else if (b == -1 || !isPrintableChar(b)) {
				return minus ? -n : n;
			} else {
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
}