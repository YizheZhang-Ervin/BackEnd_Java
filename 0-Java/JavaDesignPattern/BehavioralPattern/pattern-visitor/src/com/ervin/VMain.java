package com.ervin;

import java.io.File;
import java.io.IOException;

import com.ervin.visitor.ClassFileCleanerVisitor;
import com.ervin.visitor.FileStructure;
import com.ervin.visitor.JavaFileVisitor;


public class VMain {

	public static void main(String[] args) throws IOException {
		FileStructure fs = new FileStructure(new File("."));
		fs.handle(new JavaFileVisitor());
		fs.handle(new ClassFileCleanerVisitor());
	}
}
