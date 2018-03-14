package com.airlims.enterprise.applications.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Felix Chiu on 1/18/18.
 */
public class FileHelper {

    public static void archiveFile(File sourceFile, File destinationFile) throws IOException {
        copyFile(sourceFile, destinationFile);
        zipFile(destinationFile);
        destinationFile.delete();
    }

    public static void zipFile(File fileToZip) throws IOException {
        FileOutputStream fos = new FileOutputStream(new StringBuilder().append(fileToZip.getPath()).append(".zip").toString());
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        final byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

    public static void copyFile(File sourceFile, File destinationFile) throws IOException {
        if (!destinationFile.getParentFile().exists()) {
            destinationFile.getParentFile().mkdirs();
        } else if (destinationFile.exists()) {
            destinationFile.delete();
        }
        FileSystem fileSys = FileSystems.getDefault();
        Path srcPath = fileSys.getPath(sourceFile.getPath());
        Path destPath = fileSys.getPath(destinationFile.getPath());
        Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);

    }
}
