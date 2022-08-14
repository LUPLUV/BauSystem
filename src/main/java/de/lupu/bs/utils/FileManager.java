package de.lupu.bs.utils;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public FileManager() {
        try {
            loadFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFiles() throws IOException {
        File folder = new File("plugins//BauSystem");
        File configFile = new File("plugins//BauSystem//config.yml");
        File mapsFolder = new File("plugins//BauSystem//Maps");
        if(!folder.exists()) folder.mkdir();
        if(!mapsFolder.exists()) mapsFolder.mkdir();
        if(!configFile.exists()){
            configFile.createNewFile();
        }
    }

}
