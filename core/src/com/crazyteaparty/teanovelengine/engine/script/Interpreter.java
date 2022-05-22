package com.crazyteaparty.teanovelengine.engine.script;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.crazyteaparty.teanovelengine.engine.text.Textbox;

public class Interpreter {
	private HashMap<String, Method>  dictionary;
	Stage stage;
	Textbox textbox;
	ArrayList<String> parameters;
	String object;
	String method;
	HashMap<String, String> variables;
	

	public Interpreter(Stage stage, Textbox textbox){ //Изменить (перенести создание объектов в Interpreter (?))
		this.stage = stage;
		this.textbox = textbox;
		dictionary = new HashMap<>();
		dictionary.put("say", (Method)this::say);
	}
	
	private int getStringParameter(String str, int j) {
		String result = "";
		j++;
		while(str.charAt(j)!='"') result+=str.charAt(j++);
		parameters.add(result);
		return j;
	}
	
	private int getObjectParameter(String str, int j) {
		String name = "";
		while((str.charAt(j)!=' ')&&(str.charAt(j)!=',')&&(str.charAt(j)!=')')&&((str.charAt(j)!='=')))name+=str.charAt(j++);
		try {
			String result = variables.get(name);
			parameters.add(result);
		}catch (Exception e) {
			object = name;
		}
		return j;
	}
	
	public void disassemble(String str) {
		object = "";
		method = "";
		parameters = new ArrayList<>();
		String element = "";
		int j = 0;
		while(str.charAt(j)==' ') j++;
		while((str.charAt(j)!=' ')&&(str.charAt(j)!='(')){
			if(str.charAt(j)=='.') {
				object = element;
				element = ""; 
			}
			else {
				element+=str.charAt(j);
			}
			j++;
		}
		method = element;
		element = "";
		while((str.charAt(j)==' ')||(str.charAt(j)=='(')) j++;
		while((str.charAt(j)!=')')&&(str.charAt(j)!=';')){
			if(str.charAt(j)!=' ') {
				if(str.charAt(j)=='"')j = getStringParameter(str, j);
				else if(Character.isLetter(str.charAt(j)))j = getObjectParameter(str, j);
				else {
					if((str.charAt(j)==',')||(str.charAt(j)=='=')) {
						if(element!="") {
							parameters.add(element);
							element = "";
						}
					}
					else {
						element+=str.charAt(j);
					}
				}
			}
			j++;
		}
		if(element!="") {
			parameters.add(element);
		}
		System.out.println(object);
		System.out.println(method);
		System.out.println(parameters);
	}
	
	public void MethodCall() {
		((Method)dictionary.get(method)).call();
	}
	
	private void say() {
		textbox.setText(parameters.get(0));
	}
}


@FunctionalInterface
interface Method{
    void call();
}


