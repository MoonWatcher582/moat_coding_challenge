public class HashTest{
	public static void main(String[] args){
		MyHashMapV2<String, Integer> testMap = new MyHashMapV2<String, Integer>();
		System.out.println("Initial capacity is " + testMap.getCapacity());
		String bkr = "Russell";
		Integer p = new Integer(214);
		System.out.println("REPLACING " + testMap.put(bkr, p));
		System.out.println("REPLACING " + testMap.put("Abhishek",211));
		System.out.println("After adding 211, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		System.out.println("REPLACING " + testMap.put("Farach",513));
		System.out.println("After adding 513, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		System.out.println("REPLACING " + testMap.put("Tjang",111));
		System.out.println("After adding 111, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		System.out.println("REPLACING " + testMap.put("Sesh",112));	
		System.out.println("After adding 112, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		testMap.printTable();
		System.out.println("REPLACING " + testMap.put("Kalef",201));	
		System.out.println("After adding 201, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		System.out.println("REPLACING " + testMap.put("Baman",205));	
		System.out.println("After adding 205, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		System.out.println(testMap.get("Kalef"));
		System.out.println(testMap.get("Farach"));
		System.out.println(testMap.get(bkr));
		System.out.println(testMap.get("Tjang"));
		testMap.printTable();
		System.out.println("REPLACING " + testMap.put("Tjang", 112));
		System.out.println("After adding 112, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		System.out.println(testMap.get("Tjang"));
		System.out.println("REMOVING " + testMap.remove("Kalef"));
		System.out.println("After removing 201, SIZE: " + testMap.size() + " CAPACITY: " + testMap.getCapacity());
		testMap.printTable();
	}
}
