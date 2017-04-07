package com.example.nyambura.myfitness;

import java.io.File;

/**
 * Created by nyambura on 4/7/17.
 */

abstract class AlbumStorageDirFactory {
    public abstract File getAlbumStorageDir(String albumName);
}
