package org.tokmak.java8.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author life
 *
 */
public class StreamAndOptional 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		List<Integer> integerList = new ArrayList<Integer>();
		int i = 0;
		while (i != 10) {
			integerList.add(i);
			i++;
		}
		
//		integerList = null;
		
		usageOfNullableOptionalAndStream(integerList); // if integerList is null, this does not throws NullPointerException
		classicalUsageOfList(integerList); // if integerList is null, this throws NullPointerException
		classicalUsageOfListWithNullControl(integerList); // this one not throws exception if list is null
	}

	/**
	 * @param argIntegerList
	 * 
	 * With usage of Optional.ofNullable() method, if parameter argIntegerList is null or not
	 * this example does not throws NullPointerException
	 * 
	 */
	private static void usageOfNullableOptionalAndStream(List<Integer> argIntegerList) 
	{
		System.out.println("------------- usageOfOptionalAndStream -------------");
		
		Optional<List<Integer>> optionalList = Optional.ofNullable(argIntegerList);

		optionalList.ifPresent(integerList -> {
			integerList.stream().forEach(integerItem -> {
				System.out.println(integerItem);
			});
		});
	}
	
	/**
	 * @param argIntegerList
	 * 
	 * this one throws NullPointerException if parameter is null
	 */
	private static void classicalUsageOfList(List<Integer> argIntegerList)
	{
		System.out.println("------------- classicalUsageOfList -------------");
		for (Integer integerItem : argIntegerList) {
			System.out.println(integerItem);
		}
	}
	
	/**
	 * @param argIntegerList
	 * 
	 * this one not throws NullPointerException because of null check
	 */
	private static void classicalUsageOfListWithNullControl(List<Integer> argIntegerList) 
	{
		System.out.println("------------- classicalUsageOfListWithNullControl -------------");
		if(argIntegerList != null) 
		{
			for (Integer integerItem : argIntegerList) {
				System.out.println(integerItem);
			}	
		}
	}
}
