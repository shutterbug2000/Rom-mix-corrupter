package com.shutterbug.mix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Mix {
	
	char file1[] = new char[1049001];
	char file2[] = new char[1049001];
	public char fileOut[];
	static Mix mix = new Mix();

	public static void main(String[] args) {
		mix.load(args[0]);
		mix.load2(args[1]);
		mix.fileOut = new char[Integer.parseInt(args[2])];
		for(int i = 0; i < Integer.parseInt(args[2]); i++){
			if(i % 2 == 0){
				mix.fileOut[i] = mix.file1[i];
			}
			else{
				mix.fileOut[i] = mix.file2[i];
			}
		}
		mix.write(args[3], mix.fileOut, Integer.parseInt(args[2]));
	}
	
	public void load(String file){
		DataInputStream input = null;
		try {
			input = new DataInputStream(new FileInputStream(new File(file)));

			int offset = 0;
			while (input.available() > 0) {
				file1[offset] = (char) (input.readByte() & 0xFF);
				offset++;
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
				}
			}
		}
		}
	
	public void load2(String file){
		DataInputStream input = null;
		try {
			input = new DataInputStream(new FileInputStream(new File(file)));

			int offset = 0;
			while (input.available() > 0) {
				file2[offset] = (char) (input.readByte() & 0xFF);
				offset++;
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
				}
			}
		}
		}
	
	public void write(String file, char[] out, int size){
		DataOutputStream input = null;
		try {
			input = new DataOutputStream(new FileOutputStream(new File(file)));

			int offset = 0;
			while (offset < (size - 1)) {
				input.write((byte)(out[offset]));
				offset++;
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
				}
			}
		}
		}
	
}