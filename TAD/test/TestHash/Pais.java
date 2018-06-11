package TestHash;

public class Pais {

	private String name;
	

	public Pais(String name) {
	
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		System.out.println("123456987kxjcxjocxv");
		int sumASCII = 0;

		for (int x = 0; x < name.length(); x++) {

			sumASCII = sumASCII + name.codePointAt(x);

		}

		return ((sumASCII / name.length()));

	}
}