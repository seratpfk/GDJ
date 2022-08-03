package ex16_interface;

public class Main {

	public static void main(String[] args) {
		
		Dog dog = new Dog("백구");
		Cat cat = new Cat("냥냥이");
		Snake snake = new Snake("낼름이");
		
		Person person = new Person();
		person.foodFeed(dog, "개껌");  // 백구에게 개껌주기
		person.foodFeed(cat, "츄르");  // 냥냥이에게 츄르주기
		person.foodFeed(snake, "쥐");  // 낼름이에게 쥐주기

	}

}
