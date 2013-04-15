import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FairAndSquare {

  public static void main(String[] args) {
		try{
			// Create output file 
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			// Open source file 
			FileInputStream ifstream = new FileInputStream("C-large-practice-1.in");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(ifstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			int numberOfCase = Integer.parseInt(br.readLine());

			ArrayList<Long> fairAndSquareArray = new ArrayList<Long>();

			for (long i=0;i<=Math.pow(10, 7);i++){
				System.out.println("Testing " + i);
				if (isPalindromeNumber(i)&&isPalindromeNumber((long)Math.pow(i,2))&&Math.pow(i,2)<=Math.pow(10,14)) fairAndSquareArray.add((long) Math.pow(i, 2));
			}

			for (int i=1; i<=numberOfCase;i++){
				String[] bounds = br.readLine().split("\\s+");
				long lowerBound = Long.parseLong(bounds[0]);
				long upperBound = Long.parseLong(bounds[1]);

				long numberOfFairAndSquare = 0;

				for (Long temp : fairAndSquareArray){
					if (temp<=upperBound&&temp>=lowerBound) numberOfFairAndSquare++;
				}
				out.write("Case #" + i + ": " + numberOfFairAndSquare + "\n");
			}

			//Close the input stream
			in.close();

			//Close the output stream
			out.close();
		} catch (IOException e){
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static boolean isPalindromeNumber(long num){
		long n = num;
		long rev = 0;
		while (num > 0)
		{
			long dig = num % 10;
			rev = rev * 10 + dig;
			num = num / 10;
		}
		return n==rev;
	}
}
