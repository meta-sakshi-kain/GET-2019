package question_1;

import java.util.Scanner;

public class VirtualCommandPrompt {

	Node currentDir;
	static Node root;

	public VirtualCommandPrompt() {
		root = new Node(null, "R:");
		currentDir = root;
	}

	public String vcp(String command) {
		command += " ";
		String cmd = command.substring(0, command.indexOf(" "));
		switch (cmd) {
			case "mkdir" :
				return mkdir(command);
			case "cd" :
				return cd(command);
			case "bk" :
				return bk();
			default :
				return null;
		}
	}

	private String mkdir(String command) {
		String name = command.substring((command.indexOf(" ") + 1), (command.length() - 1));
		Node newNode = new Node(currentDir, name);
		for (int i = 0; i < currentDir.childList.size(); i++) {
			if (currentDir.childList.get(i).getName().equals(name)) {
				return "directory already exists\n" + printDir(currentDir);
			}
		}
		currentDir.childList.add(newNode);
		return printDir(currentDir);
	}

	private String cd(String command) {
		String name = command.substring((command.indexOf(" ") + 1), (command.length() - 1));
		if (!name.contains("\\")) {
			for (int i = 0; i < currentDir.childList.size(); i++) {
				if (currentDir.childList.get(i).getName().equals(name)) {
					currentDir = currentDir.childList.get(i);
					return printDir(currentDir);
				}
			}
			return "directory does not exists\n" + printDir(currentDir);
		}
		if (name.charAt(0) == 'R') {
			String remainingDir = name.substring((name.indexOf("\\") + 1),
					name.length());
			currentDir = root;
			return root.getName() + "\\" + cdWithPath(remainingDir);
		}
		return "directory does not exists\n" + printDir(currentDir);
	}

	private String cdWithPath(String name) {
		if (name.charAt(name.length() - 1) != '\\')
			return "invalid path\n" + printDir(currentDir);
		if (name.length() <= 1)
			return "";
		String child = name.substring(0, name.indexOf("\\"));
		for (int i = 0; i < currentDir.childList.size(); i++) {
			if (currentDir.childList.get(i).getName().equals(child)) {
				currentDir = currentDir.childList.get(i);
				String remainingDir = name.substring((name.indexOf("\\") + 1),
						name.length());
				return child + "\\" + cdWithPath(remainingDir);
			}
		}
		return "directory does not exists";
	}

	private String bk() {
		if (!currentDir.getName().equals(root.getName())) {
			currentDir = currentDir.getParent();
			return printDir(currentDir);
		}
		return root.getName() + "\\";
	}

	private String printDir(Node currentDir) {
		Node child = currentDir;
		String dir = child.getName() + "\\";
		while (child.getParent() != null) {
			child = child.getParent();
			dir = child.getName() + "\\" + dir;
		}
		return dir;
	}

	public static void main(String[] arg) {
		VirtualCommandPrompt v = new VirtualCommandPrompt();
		System.out.print(v.root.getName() + "\\" + "   ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (input != "exit") {
			String result = v.vcp(input);
			System.out.print("\n" + result + "   ");
			Scanner scanner1 = new Scanner(System.in);
			input = scanner1.nextLine();
		}
	}
}
