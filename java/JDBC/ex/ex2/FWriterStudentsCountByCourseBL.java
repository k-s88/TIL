package J4_ex2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FWriterStudentsCountByCourseBL {

	private final String FILE_PATH = "C:\\WorkSpace\\J4-EX_1.csv";
	private final String NEW_LINE  = System.getProperty("line.separator");
	private final String COMMA     = ",";

	public void appendData() {
		try{

	    	File file = new File( FILE_PATH );
	        FileWriter fileWriter = new FileWriter(file,true);

			StudentsCountByCourseDao dao = new StudentsCountByCourseDao();
			List<StudentsCountByCourseDto> appendDtoList = dao.selectData();

			fileWriter.write(NEW_LINE);
			fileWriter.write(NEW_LINE);
			fileWriter.write("#--集計結果--") ;
			fileWriter.write(NEW_LINE) ;
			fileWriter.write("登録支店,受講講座,受講者数") ;
			fileWriter.write(NEW_LINE) ;

			if(appendDtoList != null) {

				for(int i = 0 ; i < appendDtoList.size() ; i++){
				StringBuffer rsbuf = new StringBuffer();
					rsbuf.append(appendDtoList.get(i).getBranch());
					rsbuf.append(COMMA);
					rsbuf.append(appendDtoList.get(i).getCourse());
					rsbuf.append(COMMA);
					rsbuf.append(appendDtoList.get(i).getCount());

					fileWriter.write(rsbuf.toString());
					fileWriter.write(NEW_LINE);

				}

			}else {

				fileWriter.write("[INFO]該当のユーザー情報を取得できませんでした" ) ;

			}

			fileWriter.close();

		}
		catch(IOException e){

		        System.out.println(e);
		}
	}
}