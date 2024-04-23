package phan3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FolderList {
    public static void main(String[] args) {
        String directoryPath = "F:\\Hoc\\Anh Văn\\mm";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append("<ROOT>").append("\n");
            listFiles(directory, xmlBuilder);
            xmlBuilder.append("</ROOT>");

            // Ghi dữ liệu vào file XML
            String xmlFilePath = "folder_structure.xml";
            try {
                FileWriter fileWriter = new FileWriter(xmlFilePath);
                fileWriter.write(xmlBuilder.toString());
                fileWriter.close();
                System.out.println("Danh sách cây thư mục đã được lưu vào file XML.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Đường dẫn không tồn tại hoặc không phải là thư mục.");
        }
    }

    private static void listFiles(File directory, StringBuilder xmlBuilder) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    xmlBuilder.append("<").append(file.getName()).append(">").append("\n");
                    listFiles(file, xmlBuilder);
                    xmlBuilder.append("</").append(file.getName()).append(">").append("\n");
                } else {
                    xmlBuilder.append("<file>").append(file.getName()).append("</file>").append("\n");
                }
            }
        }
    }
}
