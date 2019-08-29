// statistics and data can be applied for further analysis 

import java.util.Scanner;
public class elementaryCellularAutomata {
    public static void main(String [] args){
        Scanner in = new Scanner (System.in);

        System.out.print("Enter an integer between 0 and 256: ");
        //actually 256 doesn't work, binary number is 100000000 out of 8

        final int WIDTH = 33;
        final int HEIGHT = 16;

        String[] array = new String[8];

        // decimal to binary
        int i = 0;
        int index = 0;
        int num = in.nextInt();
        int binary = num;
        while(num != 0){
            if (num % 2 == 0){
                array[i] = " ";
            }
            else {
                array[i] = "X";
            }
            num = num / 2;
            i++;
            index = i;
        }

        // replace empty spot with O
        for(i = index; i < array.length; i++){
            array[i] = " ";
        }

        // reverse array
        String temp;
        for(i = 0; i < array.length / 2; i++){
            temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
        }

        /*
        // test
        for (int j = 0; j < array.length; j++){
            System.out.print(array[j] + " ");
        }
        */



        // print first line
        String[] line = new String[WIDTH];
        for (int j = 0; j < line.length; j++){
            if (j == line.length / 2){
                line[j] = "X";
            }
            else{
                line[j] = " ";
            }
            System.out.print(line[j] + " ");
        }



        // prepare
        System.out.println();

        // the loop
        for (i = 0; i < HEIGHT; i++){
            generation(binary, line, array);
            System.out.println();

        }




    }

    // method for determining the next generation, invoke method for different binary
    public static void generation(int binary, String[] line, String[] array) {

        //System.out.print(line.length); // print 11

            /*
            for (int j = 0; j < line.length; j++){
                System.out.print(line[j] + " ");
            }
            */


        int i = 1;
        int a = 0;
        int b = 1;

        String k = " ";

        String[] newLine = new String[line.length];

        // the edges are blank
        newLine[0] = " ";
        newLine[newLine.length - 1] = " ";

        for(int c = 2; c < line.length; c++){
            if (line[a].equals("X") && line[b].equals("X") && line[c].equals("X"))
                k = array[0];
            else if (line[a].equals("X") && line[b].equals("X") && line[c].equals(" "))
                k = array[1];
            else if (line[a].equals("X") && line[b].equals(" ") && line[c].equals("X"))
                k = array[2];
            else if (line[a].equals("X") && line[b].equals(" ") && line[c].equals(" "))
                k = array[3];
            else if (line[a].equals(" ") && line[b].equals("X") && line[c].equals("X"))
                k = array[4];
            else if (line[a].equals(" ") && line[b].equals("X") && line[c].equals(" "))
                k = array[5];
            else if (line[a].equals(" ") && line[b].equals(" ") && line[c].equals("X"))
                k = array[6];
            else if (line[a].equals(" ") && line[b].equals(" ") && line[c].equals(" "))
                k = array[7];
            newLine[i] = k;
            a++;
            b++;

            i++;


        }

        // copy array
        for (int j = 0; j < newLine.length; j++){
            line[j] = newLine[j];
        }
        for (int j = 0; j < newLine.length; j++){
            System.out.print(newLine[j] + " ");
        }


    }



}


