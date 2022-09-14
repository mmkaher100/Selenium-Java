package MiscExcercise;

public class FilePathTest {
    public static void main(String[] args) {
       String FilePath=  System.getProperty("user.dir");
        System.out.println(FilePath);
//        C:\Users\Kaher Ahmed\IdeaProjects\DemoQA  +  \Resources\Test_Data\Mock_Data.xlsx
        String ExcelFilePath = System.getProperty("user.dir") + "//Resources//Test_Data//Mock_Data.xlsx";
    }
}
