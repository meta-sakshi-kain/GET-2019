package question_3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * class for counseling process of a College
 */
public class CounselingProcess {

	static Map<String, Integer> programs = new HashMap<String, Integer>();
	static Queue students = new Queue(10);

	/**
	 * read excel file data and store data
	 */
	private static void readExcelFile() {
		//create a file
		File file = new File("counselling.xls");
		String key = "";
		try {
			//get workbook of file
			Workbook workbook = Workbook.getWorkbook(file);
			//get first sheet of workbook
			Sheet sheet = workbook.getSheet(0);
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					//check cell type
					if (cell.getType() == CellType.LABEL)
						//generate a key for map
						key = cell.getContents();
					else
						//store programs in map
						programs.put(key, Integer.parseInt(cell.getContents()));
				}
			}
			//get next sheet of workbook
			sheet = workbook.getSheet(1);
			for (int i = 0; i < sheet.getRows(); i++) {
				Student student = new Student();
				//create string array for preference of students
				String[] preference = new String[5];
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					//first column has name 
					if (j == 0)
						student.setName(cell.getContents());
					else
						//store preference of student
						preference[j - 1] = cell.getContents();
				}
				//set preference of student
				student.setPreference(preference);
				//add student in queue
				students.enqueue(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * allocate program to students
	 */
	public static void allocateProgram() {
		try {
			//create workbook for write a file
			WritableWorkbook workbook = Workbook.createWorkbook(new File("result.xls"));
			//create sheet in workbook
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			//set row index in sheet
			int rowNo = 0;
			for (int i = 0; i < 10; i++) {
				//get student from queue
				Student student = students.dequeue();
				for (int j = 0; j < 5; j++) {
					//check preference program capacity
					if (programs.get(student.getPreference()[j]) > 0) {
						//create label for name
						Label name = new Label(0, rowNo, student.getName());
						sheet.addCell(name);
						Label program = new Label(1, rowNo++, student.getPreference()[j]);
						//add cell in sheet
						sheet.addCell(program);
						//decrease capacity of program 
						programs.put(student.getPreference()[j], programs.get(student.getPreference()[j]) - 1);
						break;
					}
				}
			}
			//write workbook
			workbook.write();
			//close workbook
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		//read excel file
		readExcelFile();
		//allocate programs to students
		allocateProgram();
	}
}
