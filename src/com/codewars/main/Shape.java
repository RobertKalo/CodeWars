/*Although shapes can be very different by nature, they can be sorted by the size of their area.

Task:

Create different shapes that can be part of a sortable list. The sort order is based on the size of their respective areas:
The area of a Square is the square of its side
The area of a Rectangle is width multiplied by height
The area of a Triangle is base multiplied by height divided by 2
The area of a Circle is the square of its radius multiplied by π
The area of a CustomShape is given

The default sort order of a list of shapes is ascending on area size:
double side = 1.1234;
double radius = 1.1234;
double base = 5;
double height = 2;

ArrayList<Shape> shapes = new ArrayList<Shape>();
shapes.add(new Square(side));
shapes.add(new Circle(radius));
shapes.add(new Triangle(base, height));

Collections.sort(shapes);
Use the correct π constant for your circle area calculations:
Math.PI

*/
package com.codewars.main;

public class Shape implements Comparable<Shape> {

	protected double area;

	private void setArea( double d ) {
		this.area=d;
	}

	public class Rectangle extends Shape {

		public Rectangle(double width, double height) {
			this.area = height * width;
		}

	}

	public class Triangle extends Shape {

		public Triangle(double base, double height) {
			setArea( base * height / 2 );
		}
		


	}

	public class Circle extends Shape {

		public Circle(double radius) {
			setArea( radius * radius * Math.PI );
		}

	}

	public class Square extends Shape {

		public Square(double side) {
			setArea( side * side );
		}

	}

	public class CustomShape extends Shape {

		public CustomShape(double area) {
			setArea( area );
		}

	}

	@Override
	public int compareTo( Shape o ) {
		return Double.compare( area, area );
	}

}
