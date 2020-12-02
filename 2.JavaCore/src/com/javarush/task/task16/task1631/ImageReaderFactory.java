package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes e){

            if(e == ImageTypes.JPG) return new JpgReader();
            else if(e == ImageTypes.BMP) return new BmpReader();
            else if(e == ImageTypes.PNG) return new PngReader();
            else throw new IllegalArgumentException();



    }
}
