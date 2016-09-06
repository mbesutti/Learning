package com.mbesutti.presenterPicker;

import java.io.IOException;

public class PresenterPicker {
	public static void main(String[] arguments) throws IOException {
		Args args = new Args(arguments);
		Presenters repository = new Presenters();
		if (args.empty()) {
			String presenter = Picker.pickFrom(repository.all());
			System.out.println("Presenter: " + presenter);
			return;
		}
		if (args.on("help")) {
			StringBuilder help = new StringBuilder();
			help.append("Possible arguments:");
			help.append("\n<no arguments> -> get random presenter");
			help.append("\nadd:<name>");
			help.append("\nremove:<name>");
			help.append("\nlist");
			System.out.println(help.toString());
		} else if (args.on("add")) {
			repository.add(args.value());
		} else if (args.on("remove")) {
			repository.remove(args.value());
		} else if (args.on("list")) {
			System.out.println("Presenters:");
			for (String presenter : repository.all()) {
				System.out.println("- " + presenter);
			}
		}
	}
}
