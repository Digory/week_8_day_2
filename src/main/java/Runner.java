import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        // Test SAVE

        Folder folder1 = new Folder("Digory's massive folder");
        DBHelper.save(folder1);
        File file1 = new File("Digory's little file", "jpg", folder1);
        DBHelper.save(file1);

        // Test UPDATE

        folder1.setTitle("Digory's medium-sized folder");
        DBHelper.update(folder1);
        file1.setName("Somebody else's file");
        DBHelper.update(file1);

        // Test DELETE

        DBHelper.delete(file1);
        DBHelper.delete(folder1);

        // Test READ

        Folder folder2 = new Folder("Brendan's folder");
        File file2 = new File("A good file", "odt", folder1);
        DBHelper.save(folder1);
        DBHelper.save(file1);
        DBHelper.save(folder2);
        DBHelper.save(file2);

        Folder foundFolder = DBHelper.findById(Folder.class, folder1.getId());
        File foundFile = DBHelper.findById(File.class, file2.getId());

        List<Folder> foundFolders = DBHelper.findAll(Folder.class);
        List<File> foundFiles = DBHelper.findAll(File.class);
    }
}
