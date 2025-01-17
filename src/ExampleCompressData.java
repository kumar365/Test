
//program to compress and uncompressed  the data
import java.io.*;
import java.util.zip.*;

class ExampleCompressData {
	public static void main(String[] args) throws IOException {
		compressData();
	}

	// DeflaterOutputStream example
	public static void compressData() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("input.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("temp.txt");
		DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(fileOutputStream);
		int ch;
		while ((ch = fileInputStream.read()) != -1) {
			deflaterOutputStream.write(ch);
		}
		fileInputStream.close();
		deflaterOutputStream.close();
	}

	// InflaterInputStream example
	public static void uncompressData() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("temp.txt”");
		InflaterInputStream inflaterInputStream = new InflaterInputStream(fileInputStream);
		FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
		int ch;
		while ((ch = inflaterInputStream.read()) != -1) {
			fileOutputStream.write(ch);
		}
		inflaterInputStream.close();
		fileOutputStream.close();
	}
}
