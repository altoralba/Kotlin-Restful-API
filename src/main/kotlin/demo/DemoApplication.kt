package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
class DataResource {
	@GetMapping("/groceries")
	fun getShoppingList(): List<Cart> = listOf(
			Cart("5", "Potatoes"),
			Cart("2", "Cans of Corned Tuna"),
			Cart("1", "Bottle of Ketchup"),
			Cart("12", "Eggs"),
	)

	@GetMapping("/pricing")
	fun getNumbers(): List<Message> = listOf(
			Message("5", "Egg"),
			Message("25", "Corned Tuna Can"),
			Message("30", "Banana Ketchup"),
			Message("8", "Potato"),
	)

	@GetMapping("/greet")
	fun getBuyerName(@RequestParam("buyer") name: String): String {
		return "Hello, $name!"
	}
}

data class Cart(val qty: String?, val item: String)

data class Message(val price: String?, val item: String)