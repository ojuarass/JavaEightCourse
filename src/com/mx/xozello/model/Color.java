package com.mx.xozello.model;

public class Color {
	private int red;
	private int green;
	private int blue;

	public Color(int red, int green, int blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Color [red=");
		builder.append(red);
		builder.append(", green=");
		builder.append(green);
		builder.append(", blue=");
		builder.append(blue);
		builder.append("]");
		return builder.toString();
	}

}
