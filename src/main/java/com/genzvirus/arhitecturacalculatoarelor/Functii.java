package com.genzvirus.arhitecturacalculatoarelor;

public class Functii {

    public static String Sum(String Nr1, String Nr2){
        String result = "";
        String transfer = "0";
        int length = Nr1.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr1 = "0" + Nr1;
            }
        length = Nr2.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr2 = "0" + Nr2;
            }
        for(int i = 7; i >= 0; i--){
            // daca am 0 si 0 rezultatul sumei este 0
            // daca am 1 si 0 rezultatul sumei este 1
            // daca am 0 si 1 rezultatul sumei este 1
            // daca am 1 si 1 rezultatul sumei este 0 si transfer 1
            if(Nr1.charAt(i) == '1' && Nr2.charAt(i) == '1'){
                result = (transfer == "1" ? "1" : "0") + result;
                if(transfer == "0") transfer = "1";
            }else if(Nr1.charAt(i) == '1' || Nr2.charAt(i) == '1'){
                result = (transfer == "1" ? "0" : "1") + result;
            }else {
                result = (transfer == "1" ? "1" : "0") + result;
                if(transfer == "1") transfer = "0";
            }
        }
        if(transfer == "1") result = "1" + result;
        return result;
    }

    public static String Minus(String Nr1, String Nr2){
        String result = "";
        String sign = "";
        int length = Nr1.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr1 = "0" + Nr1;
            }
        length = Nr2.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr2 = "0" + Nr2;
            }
        for(int i = 0; i < 8; i++){
            if(Integer.parseInt(Character.toString(Nr1.charAt(i))) < Integer.parseInt(Character.toString(Nr2.charAt(i)))){
                String copy = Nr1;
                Nr1 = Nr2;
                Nr2 = copy;
                sign = "-";
                break;
            }
        }
        for(int i = 0; i < 8; i++){
            // daca am 0 si 0 rezultatul scaderii este 0
            // daca am 1 si 0 rezultatul scaderii este 1
            // daca am 0 si 1 rezultatul scaderii este 1 si se modifica cifra dinainte in 0
            // daca am 1 si 1 rezultatul scaderii este 0
            if(Nr1.charAt(i) == '0' && Nr2.charAt(i) == '0'){
                result = result + "0";
            }
            else if(Nr1.charAt(i) == '1' && Nr2.charAt(i) == '0'){
                result = result + "1";
            }
            else if(Nr1.charAt(i) == '0' && Nr2.charAt(i) == '1'){
                int j = i - 1;
                while(result.charAt(j) == '0' && j > 0){
                    j--;
                }
                String copy = "";
                for (int k = 0; k < j; k++){
                    copy = copy + result.charAt(k);
                }
                copy = copy + "0";
                for(int k = j + 1; k < i; k++){
                    copy = copy + "1";
                }

                result = copy + "1";
            }
            else result = result + "0";
        }
        return sign + result;
    }

    public static String OR(String Nr1, String Nr2){
        String result = "";
        int length = Nr1.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr1 = "0" + Nr1;
            }
        length = Nr2.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr2 = "0" + Nr2;
            }
        for(int i = 0; i < 8; i++){
            // daca am 0 si 0 rezultatul este 0
            // daca am 1 si 0 rezultatul este 1
            // daca am 0 si 1 rezultatul este 1
            // daca am 1 si 1 rezultatul este 1
            if(Nr1.charAt(i) == '1' || Nr2.charAt(i) == '1'){
                result = result + "1";
            }else result = result + "0";
        }
        return result;
    }

    public static String AND(String Nr1, String Nr2){
        String result = "";
        int length = Nr1.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr1 = "0" + Nr1;
            }
        length = Nr2.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr2 = "0" + Nr2;
            }
        for(int i = 0; i < 8; i++){
            // daca am 0 si 0 rezultatul este 0
            // daca am 1 si 0 rezultatul este 0
            // daca am 0 si 1 rezultatul este 0
            // daca am 1 si 1 rezultatul este 1
            if(Nr1.charAt(i) == '1' && Nr2.charAt(i) == '1'){
                result = result + "1";
            }else result = result + "0";
        }
        return result;
    }

    public static String XOR(String Nr1, String Nr2){
        String result = "";
        int length = Nr1.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr1 = "0" + Nr1;
            }
        length = Nr2.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr2 = "0" + Nr2;
            }
        for(int i = 0; i < 8; i++){
            // daca am 0 si 0 rezultatul este 0
            // daca am 1 si 0 rezultatul este 1
            // daca am 0 si 1 rezultatul este 1
            // daca am 1 si 1 rezultatul este 0
            if(Nr1.charAt(i) != Nr2.charAt(i)){
                result = result + "1";
            }else result = result + "0";
        }
        return result;
    }

    public static String NOT(String Nr){
        String result = "";
        int length = Nr.length();
        if(length < 8)
            for(int i = 0; i < 8 - length; i++){
                Nr = "0" + Nr;
            }
        for(int i = 0; i < 8; i++){
            // daca am 0 rezultatul este 1
            // daca am 1 rezultatul este 0
            if(Nr.charAt(i) == '0'){
                result = result + "1";
            }else result = result + "0";
        }
        return result;
    }


}
