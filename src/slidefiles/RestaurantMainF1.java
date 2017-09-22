package slidefiles;

public class RestaurantMainF1 {

	public static void main(String[] args) {
		RestaurantClass rest = new RestaurantClass();

		rest.restaurants.forEach((final String name) -> System.out.println(name));
	}
}