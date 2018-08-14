import db.DBFolder;
import db.DBHelper;
import db.DBOwner;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        // Test SAVE

        Owner owner1 = new Owner("Digory", "Dig-the-wig");
        DBHelper.save(owner1);
        Folder folder1 = new Folder("Digory's massive folder", owner1);
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

        Folder folder2 = new Folder("Brendan's folder but Digory can have it", owner1);
        File file2 = new File("A good file", "odt", folder1);
        DBHelper.save(folder1);
        DBHelper.save(file1);
        DBHelper.save(folder2);
        DBHelper.save(file2);

        Folder foundFolder = DBHelper.findById(Folder.class, folder1.getId());
        File foundFile = DBHelper.findById(File.class, file2.getId());

        List<Folder> foundFolders = DBHelper.findAll(Folder.class);
        List<File> foundFiles = DBHelper.findAll(File.class);

        // Test getFilesInFolder(Folder)

        List<File> foundFilesInFolder = DBFolder.getFilesInFolder(folder1);

        // Test getAllFoldersOwnedBy(Owner)

        Owner owner2 = new Owner("Brendan", "BT");
        List<Folder> foundFoldersOwnedByOwner1 = DBOwner.getAllFoldersOwnedBy(owner1);
        List<Folder> foundFoldersOwnedByOwner2 = DBOwner.getAllFoldersOwnedBy(owner2);
    }
}
