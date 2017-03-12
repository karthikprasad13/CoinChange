package solutions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputProcessor {

	public static int process(String path) throws FileNotFoundException {
		String line = "";
		String cvsSplitBy = ",";
		FileReader file = new FileReader(path);
		int length = 0;
		int size = 0;
		try (BufferedReader br = new BufferedReader(file)) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				if (data.length > length) {
					length = data.length;
					size = 1;
				} else if (data.length == length) {
					size++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
				}
		}

		return length;
	}

	// utility to find last n lines of a file
	public static String tail(File file, int lines) {
		java.io.RandomAccessFile fileHandler = null;
		try {
			fileHandler = new java.io.RandomAccessFile(file, "r");
			long fileLength = fileHandler.length() - 1;
			StringBuilder sb = new StringBuilder();
			int line = 0;

			for (long filePointer = fileLength; filePointer != -1; filePointer--) {
				fileHandler.seek(filePointer);
				int readByte = fileHandler.readByte();

				if (readByte == 0xA) {
					if (filePointer < fileLength) {
						line = line + 1;
					}
				} else if (readByte == 0xD) {
					if (filePointer < fileLength - 1) {
						line = line + 1;
					}
				}
				if (line >= lines) {
					break;
				}
				sb.append((char) readByte);
			}

			String lastLine = sb.reverse().toString();
			return lastLine;
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (java.io.IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (fileHandler != null)
				try {
					fileHandler.close();
				} catch (IOException e) {
				}
		}
	}
}
