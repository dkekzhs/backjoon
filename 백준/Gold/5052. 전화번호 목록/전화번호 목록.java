
import java.io.*;
import java.util.*;

public class Main {
	static Set<String> data;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		while(N --> 0){
			M = Integer.parseInt(br.readLine());
			data = new HashSet<>();

			String[] temp = new String[M];
			for (int i = 0; i < M; i++) {
				temp[i] = br.readLine();
			}
			Arrays.sort(temp, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return Integer.compare(o1.length(), o2.length());

				}
			});

			boolean flag = true;

			for (String number : temp) {
				for (int i = 0; i < number.length(); i++) {
					if (data.contains(number.substring(0, i))) {
						flag = false;
						break;
					}
				}
				if(!flag) break;
				data.add(number);
			}

			System.out.println(flag ? "YES" : "NO");

		}

	}

}


