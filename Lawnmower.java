import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class Lawnmower {
  public static void main(String args[])
	{
		try{
			// Create output file 
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			// Open source file 
			//FileInputStream ifstream = new FileInputStream("test.txt");
			FileInputStream ifstream = new FileInputStream("B-large-practice.in");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(ifstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			//get the number of case
			int numberOfCase = Integer.parseInt(br.readLine());

			for (int i=1; i<=numberOfCase;i++){
				String[] dimension = br.readLine().split("\\s+");
				int numrow = Integer.parseInt(dimension[0]);
				int numcol = Integer.parseInt(dimension[1]);
				int[][] field = new int[numrow][numcol];
				for (int j=0; j<numrow;j++){
					String[] temp = br.readLine().split("\\s+");
					for (int k=0;k<numcol;k++)
						field[j][k] = Integer.parseInt(temp[k]);
				}

				boolean condition = true;
				
				//check if each element is either the max in its row or its column
				for (int j=0; j<numrow;j++){
					for (int k=0;k<numcol;k++){
						boolean maxInCol = true, maxInRow=true;

						for (int m=0;m<numrow;m++)
							if (field[m][k]>field[j][k]){
								maxInCol = false;
								break;
							}

						for (int n=0;n<numcol;n++)
							if (field[j][n]>field[j][k]){
								maxInRow=false;
								break;
							}

						if (!(maxInCol||maxInRow)) {
							condition = false;
							break;
						}
					}
					if (condition==false) break;
				}

				String resulttext = (condition)? "YES" : "NO";

				out.write("Case #" + i + ": " + resulttext + "\n");
			}

			//Close the input stream
			in.close();

			//Close the output stream
			out.close();
		}catch (IOException e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}
