package J4_ex1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FWriterStudentListBL {

	private final String FILE_PATH = "C:\\WorkSpace\\J4-EX_1.csv";
	private final String NEW_LINE  = System.getProperty("line.separator");
	private final String COMMA     = ",";

	public void extractData() {

		try{

	    	File file = new File( FILE_PATH );
	        FileWriter fileWriter = new FileWriter(file);

			StudentListDao dao = new StudentListDao();
			List<StudentListDto> extractedDtoList = dao.selectData();

			fileWriter.write("#--受講生一覧--") ;
			fileWriter.write(NEW_LINE) ;
			fileWriter.write("名前,性別,年齢,職歴,登録支店,受講講座") ;
			fileWriter.write(NEW_LINE) ;

			if(extractedDtoList != null) {

				for(int i = 0 ; i < extractedDtoList.size() ; i++){
				StringBuffer rsbuf = new StringBuffer();
					rsbuf.append(extractedDtoList.get(i).getName());
					rsbuf.append(COMMA);
					rsbuf.append(extractedDtoList.get(i).getGender());
					rsbuf.append(COMMA);
					rsbuf.append(extractedDtoList.get(i).getAge());
					rsbuf.append(COMMA);
					rsbuf.append(extractedDtoList.get(i).getCareer());
					rsbuf.append(COMMA);
					rsbuf.append(extractedDtoList.get(i).getBranch());
					rsbuf.append(COMMA);
					rsbuf.append(extractedDtoList.get(i).getCourse());

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