package J4_ex2;

public class FWriterStudentInfoMain {
	public static void main(String[] args) {

		FWriterStudentListBL bl1 = new FWriterStudentListBL();
		bl1.extractData();

		FWriterStudentsCountByCourseBL bl2 = new FWriterStudentsCountByCourseBL();
		bl2.appendData();


	}

}