package com.mx.xozello.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.mx.xozello.apple.function.BufferedReaderProcessor;

public class BufferedReaderExample {

	public static void main(String args[]) {
		try {
			String oneLine = processFile((BufferedReader br) -> br.readLine());
			String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try  (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return p.process(br);
		}
	}
}
