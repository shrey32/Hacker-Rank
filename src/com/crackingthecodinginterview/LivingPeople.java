package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * Given a list of people with their birth and death years, implement a method
 * to compute the year with the most number of people alive. You may assume that
 * all people were born between 1900 and 2000 (inclusive). If a person was alive
 * during any portion of that year, they should be included in that year's
 * count. For example, Person (birth= 1908, death= 1909) is included in the
 * counts for both 1908 and 1909
 * </p>
 * 
 * @author Shrey
 *
 */
public class LivingPeople {

	public static void main(String[] args) {
		//System.out.println(Arrays.toString(mostPeopleLivingInAnYearBruteForce(people())));
		System.out.println(livingPeople(people()));
	}

	public static int[] mostPeopleLivingInAnYearBruteForce(List<Person> people) {
		int[] res = new int[2];
		Map<Integer, Integer> census = new HashMap<>();
		for (Person person : people) {
			for (int i = person.birth; i <= person.death; i++) {
				census.put(i, census.getOrDefault(i, 0) + 1);
			}
		}
		System.out.println(census);
		int max = 0;
		for (Integer year : census.keySet()) {
			int population = census.get(year);
			if (max < population) {
				max = population;
				res[0] = year;
				res[1] = population;
			}
		}
		return res;
	}

	public static int livingPeople(List<Person> people) {
		final int[] births = new int[400];
		final int[] deaths = new int[400];
		for (Person person : people) {
			births[person.birth - 1700]++;
			deaths[person.death - 1700]++;
		}

		int maxPop = 0;
		int population = 0;
		int yearOffset = 0;
		for (int i = 0; i < 400; i++) {
			population += births[i];
			if (maxPop < population) {
				maxPop = population;
				yearOffset = i;
			}
			population -= deaths[i];
		}
		return 1700 + yearOffset;
	}

	private static List<Person> people() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(2000, 2010));
		people.add(new Person(1975, 2005));
		people.add(new Person(1975, 2003));
		people.add(new Person(1803, 1809));
		people.add(new Person(1750, 1869));
		people.add(new Person(1840, 1935));
		people.add(new Person(1803, 1921));
		people.add(new Person(1894, 1921));
		return people;
	}

	private static class Person {
		int birth, death;

		public Person(int birth, int death) {
			this.birth = birth;
			this.death = death;
		}
	}

}
