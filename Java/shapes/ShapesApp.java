public class ShapesApp {
	public static void main(String[] args) {
		// an array of shapes, why does it work?
		Shape [] shapes = 	new Shape[]{
			new Rectangle(2,3),
			new Circle(4),
			new Triangle(4,5)
		};

		for(Shape s: shapes){
			System.out.println(s.calculateArea());
			// TODO: how to check runtime type?

			// TODO: how to (nicely) print an object?
		}
	}
}
