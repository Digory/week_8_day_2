import db.DBHelper;
import models.File;
import models.Folder;

public class Runner {

    public static void main(String[] args) {
        Folder folder = new Folder("Digory's massive folder");
        DBHelper.save(folder);
        File file = new File("Digory's little file", "jpg", folder);
        DBHelper.save(file);
    }
}
