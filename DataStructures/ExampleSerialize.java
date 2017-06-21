package problems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExampleSerialize implements Serializable {
	private String firstName;
	private String lastName;
	
	public ExampleSerialize(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public String toString() {
        return "ExampleSerialize [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public static void main(String[] args) {
		String filename = "time.ser";
        ExampleSerialize p = new ExampleSerialize("Lars", "Vogel");

        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
                fos = new FileOutputStream(filename);
                out = new ObjectOutputStream(fos);
                out.writeObject(p);

                out.close();
        } catch (Exception ex) {
                ex.printStackTrace();
        }
        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
                fis = new FileInputStream(filename);
                in = new ObjectInputStream(fis);
                p = (ExampleSerialize) in.readObject();
                in.close();
        } catch (Exception ex) {
                ex.printStackTrace();
        }
        System.out.println(p);
	}
}
