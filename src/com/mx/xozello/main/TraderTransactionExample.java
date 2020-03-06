package com.mx.xozello.main;

import java.util.Arrays;
import java.util.List;
//import java.util.Set;

import com.mx.xozello.model.Trader;
import com.mx.xozello.model.Transaction;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
//import static java.util.stream.Collectors.toSet;

public class TraderTransactionExample {

	static Trader raoul = new Trader("Raoul", "Cambridge");
	static Trader mario = new Trader("Mario", "Milan");
	static Trader alan = new Trader("Alan", "Cambridge");
	static Trader brian = new Trader("Brian", "Cambridge");

	static List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

	public static void main(String[] args) {
		getTransactions2011();
		getCities();
		getCambridgeTraders();
		getTraderNames();
		isAnyFromMilan();
		getCambridgeTraderValues();
		getHighestValue();
		getTransactionWithSmallestValue();
	}

	public static void getTransactions2011() {
		List<Transaction> transactions2011 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(comparing(Transaction::getValue)).collect(toList());
		System.out.println("TRANSACTIONS IN 2011 ORDERED BY VALUE:");
		transactions2011.forEach(System.out::println);

	}

	public static void getCities() {
		List<String> cities = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct()
				.collect(toList());
//		List<String> cities1 = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());
//		Set<String> cities2 = transactions.stream().map(t -> t.getTrader().getCity()).collect(toSet());
		System.out.println("\nCITIES WHERE THE TRADERS WORK:");
		cities.forEach(System.out::println);
	}

	public static void getCambridgeTraders() {
		List<Trader> traders = transactions.stream().map(Transaction::getTrader)
				.filter(t -> "Cambridge".equals(t.getCity())).distinct().sorted(comparing(Trader::getName))
				.collect(toList());
		System.out.println("\nTRADERS FROM CAMBRIDGE ORDERED BY NAME:");
		traders.forEach(System.out::println);
	}

	public static void getTraderNames() {
		String traderNames = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("",
				(a, b) -> a + b);
		System.out.println("\nTRADERS NAMES SORTED ALPHABETICALLY:\n".concat(traderNames));
	}

	public static void isAnyFromMilan() {
		System.out.println("\nARE THERE ANY TRADERS BASED IN MILAN?\n"
				+ (transactions.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity())) ? "yes" : "no"));
	}

	public static void getCambridgeTraderValues() {
		System.out.println("\nCAMBRIDGE TRANSACTION VALUES:");
		transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue)
				.forEach(System.out::println);
	}

	public static void getHighestValue() {
		System.out.println("\nHIGHEST VALUE OF ALL TRANSACTIONS:");
		transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
	}

	public static void getTransactionWithSmallestValue() {
		System.out.println("\nTRANSACTION WITH SMALLEST VALUE:");
		transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2)
				.ifPresent(System.out::println);
	}
}
