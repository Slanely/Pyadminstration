package com.GlobalClasses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component

public class FilePath {

    class _filePath{

    }

    @Value("${my.resources}")
    private String _resourcesPath;

    public static String resourcesPath;

    public String getResPath() {
        return _resourcesPath;
    }
    public static String privateResURI = "/res/";
    public static String publicResURI = "/pubres/";

    public static String getPrivateResPath() {
         return resourcesPath + File.separator + "privateres" + File.separator;
    }

    public static String getPublicResPath() {
        return resourcesPath + File.separator + "publicres" + File.separator;
    }

}

