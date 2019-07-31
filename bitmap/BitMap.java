package bitmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BitMap {
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits/8+1];
    }

    public void set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 8;
        int bitIndex = k % 8;
        bytes[byteIndex] |= (1 << bitIndex);
        System.out.println("byteIndex:"+bitIndex+", val:"+ Arrays.toString(bytes));
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 8;
        int bitIndex = k % 8;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
    /*
    <<      :     左移运算符，num << 1,相当于num乘以2

    >>      :     右移运算符，num >> 1,相当于num除以2

    >>>    :     无符号右移，忽略符号位，空位都以0补齐
     */

    public static void main(String[] args) {
//        System.out.println(3<<2);
        byte a =  (1 << 2);
        byte b = 2;
        b |= a;
//        System.out.println(b);

        BitMap bitMap = new BitMap(100);
//        for(int i=1;i<=8;i++) {
//            bitMap.set(i);
//
//        }
//
//        for(int i=1;i<30;i++) {
//            System.out.println(bitMap.get(i));
//        }

        List<String> list = new ArrayList<>();
        if(list.isEmpty()){
            list = Collections.emptyList();
            list = null;
        }
        for(String l : list){

            System.out.println(l.isEmpty());
        }

    }
}

