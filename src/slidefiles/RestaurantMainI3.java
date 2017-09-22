package slidefiles;

import java.util.function.Consumer;

public class RestaurantMainI3 {

	public static void main(String[] args) {
		RestaurantClass rest = new RestaurantClass();

		rest.restaurants.forEach(new Consumer<String>() {
			public void accept (final String name) {
				System.out.println(name);
			}
		});
	}
}