package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = Arrays.asList(1, 2, 3);
		List<Integer> multiplication = numbers.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(multiplication);
		numbers.stream().map(x -> x * x).forEach(x -> System.out.println(x));

		List<String> words = Arrays.asList("Beta", "Gama", "Apple", "Banana", "Carrot");

		List<String> result = words.stream().filter(word -> word.startsWith("A")).collect(Collectors.toList());
		System.out.println(result);

		List<String> sortedResult = words.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedResult);
		
		
	}

}
