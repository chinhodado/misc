void Main()
{
	string s = Console.ReadLine();
	string current = s;
	
	HashSet<string> set = new HashSet<string>();
	while (true) {
		string sum = GetNext(current);
		current = sum;
		if (sum == "1") {
			Console.WriteLine("Ended: 1");
			return;
		}
		else if (!set.Contains(sum)) {
			set.Add(sum);
		}
		else {
			Console.WriteLine("Loop infinitely");
			return;
		}
	}
}


string GetNext(string input) {
	char[] tokens = input.ToCharArray();
	int[] numTokens = tokens.Select(s => (int)Math.Pow(int.Parse(s + ""), 2)).ToArray();
	return numTokens.Sum() + "";
}
