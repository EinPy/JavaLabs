package cardreader;

public class DeBug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var test = new UserTable();
		System.out.println(test.find(24073));
		System.out.println(test.find(24074));
		System.out.println(test.findByName("Jens Holmgren"));
//		test.print();
		var usr = new User(1234, "Einar");
		test.add(usr);
//		test.print();
		//the amount of users is incremented by one when one user is added manually
		System.out.println(test.testFind());
		// testfind returns 0, --> all users can be found
	}

}
