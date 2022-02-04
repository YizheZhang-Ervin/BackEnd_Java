package com.ervin;

import com.ervin.command.Command;
import com.ervin.command.CopyCommand;
import com.ervin.command.PasteCommand;
import com.ervin.command.TextEditor;


public class Main {

	public static void main(String[] args) {
		TextEditor editor = new TextEditor();
		editor.add("Command pattern in text editor.\n");
		Command copy = new CopyCommand(editor);
		copy.execute();
		editor.add("----\n");
		Command paste = new PasteCommand(editor);
		paste.execute();
		System.out.println(editor.getState());
	}
}
