package fr.isika.cda17.project3.utils;

public class  BarcodeFactory {

	private BarcodeFactory(){}
	
    public static Barcode createBarcode(BarcodeDatamatrix barcodeDatamatrix, String code) {          
        return createBarcode(barcodeDatamatrix, code, true);
    }  

    public static Barcode createBarcode(BarcodeDatamatrix barcodeDatamatrix, String code, boolean crc) {
        Barcode barcode = new BarcodeDatamatrix(code);
        return barcode;
        }
    }  